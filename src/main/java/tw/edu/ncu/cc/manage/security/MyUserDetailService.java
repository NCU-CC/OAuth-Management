package tw.edu.ncu.cc.manage.security;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import tw.edu.ncu.cc.manage.config.SecurityConfig;
import tw.edu.ncu.cc.manage.domain.User;
import tw.edu.ncu.cc.manage.enums.RoleEnum;
import tw.edu.ncu.cc.manage.exception.OAuthServiceUnavailableException;
import tw.edu.ncu.cc.manage.service.IUserService;

import com.google.inject.internal.Lists;

@Service
public class MyUserDetailService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

	private static final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

	@Autowired
	private IUserService userService;
	
	/**
	 * 可存取本系統的role
	 */
	private static final List<String> PERMIT_ROLES = RoleEnum.availableRoles();

	@Override
	public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException, NoSuchUserRoleException {

		logger.debug("OpenID token {}", token);
		logger.debug("使用者IP {}, User-Agent {} ", ip(), userAgent());
		
		if (!isAvailableRole(token)) {
			logger.warn("使用者role不允許存取本系統, expected {}, received {} ", PERMIT_ROLES, roles(token));
			throw new NoSuchUserRoleException(token, PERMIT_ROLES);
		}

		String username = StringUtils.substringAfterLast((String) token.getPrincipal(), "/");

		if (StringUtils.isEmpty(username)) {
			logger.warn("空白的使用者帳號");
			throw new UsernameNotFoundException((String) token.getPrincipal());
		}

		User user = findOrCreateUserIfNotExist(username);

		addUsernameToSession(user);
		
		return user;
	}
	
	
	/**
	 * 使用者ip
	 * @return
	 */
	private String ip() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	    HttpServletRequest req = sra.getRequest();
	    return req.getRemoteAddr();
	}
	
	/**
	 * 使用者ip
	 * @return
	 */
	private String userAgent() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	    HttpServletRequest req = sra.getRequest();
	    return req.getHeader("User-Agent");
	}
	
	/**
	 * 該使用者的role有權限access本系統
	 * 
	 * @param token
	 */
	private boolean isAvailableRole(OpenIDAuthenticationToken token) {
		return CollectionUtils.containsAny(PERMIT_ROLES, roles(token));
	}

	/**
	 * 提取角色屬性
	 * 
	 * @param token
	 * @return
	 */
	private List<String> roles(OpenIDAuthenticationToken token) {
		List<OpenIDAttribute> attributes = token.getAttributes();

		for (OpenIDAttribute attribute : attributes) {

			if (isRoleAttribute(attribute)) {

				logger.debug("使用者 OpenID roles: {}", attribute);

				String roles = attribute.getValues().get(0);
				roles = StringUtils.remove(roles, "\"");
				roles = StringUtils.remove(roles, "[");
				roles = StringUtils.remove(roles, "]");

				return Lists.newArrayList(roles.split(","));
			}
		}
		return Collections.emptyList();
	}

	/**
	 * 這個attribute是role屬性
	 * 
	 * @param attribute
	 * @return
	 */
	private boolean isRoleAttribute(OpenIDAttribute attribute) {
		return SecurityConfig.AX_NAME_ROLE.equals(attribute.getName());
	}

	/**
	 * 尋找使用者資訊，若不存在則新增
	 * @param username
	 * @return
	 */
	private User findOrCreateUserIfNotExist(String username) {
		User user = null;
		
		try {
			
			Optional<User> result = this.userService.find(username);
			if (result.isPresent()) {
				
				user = result.get();
				logger.debug("使用者資訊已存在 {} ", user);
				
			} else {
				
				user = new User(username);
				logger.debug("新增使用者資訊 {} ", user);
				this.userService.create(user);
				
			}
			
		} catch (OAuthServiceUnavailableException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	private void addUsernameToSession(User user) {
		RequestContextHolder.getRequestAttributes().setAttribute("username", user.getName(), RequestAttributes.SCOPE_SESSION);
	}
}
