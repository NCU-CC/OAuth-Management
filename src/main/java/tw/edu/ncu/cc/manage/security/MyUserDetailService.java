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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import tw.edu.ncu.cc.manage.config.SecurityConfig;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.enums.RoleEnum;
import tw.edu.ncu.cc.manage.service.IPersonService;

import com.google.inject.internal.Lists;

@Service
public class MyUserDetailService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

	private static final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

	@Autowired
	private IPersonService personService;

	/**
	 * 允許存取本系統的role
	 */
	private static final List<String> PERMIT_ROLES = RoleEnum.availableRoles();

	@Override
	public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException, NoSuchUserRoleException {

		logger.debug("OpenID token {}", token);

		if (!isAvailableRole(token)) {
			throw new NoSuchUserRoleException(token, PERMIT_ROLES);
		}

		String account = StringUtils.substringAfterLast((String) token.getPrincipal(), "/");

		if (StringUtils.isEmpty(account)) {
			throw new UsernameNotFoundException(token.toString());
		}
		
		Optional<Person> person = this.personService.findByAccount(account);
		if (person.isPresent()) {
			logger.debug("使用者已註冊，回傳已儲存資料");
			this.personService.refreshLastIp(person.get(), ip());
			return person.get();
		}

		logger.debug("使用者未註冊，產生新資料");

		Person newPerson = new Person(account, roles(token));
		newPerson.setIpCreated(ip());
		newPerson.setIpLastActived(ip());
		this.personService.create(newPerson);
		// TODO publish new user event to oauth service
		return newPerson;
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
	 * 這個attribute是屬性role
	 * 
	 * @param attribute
	 * @return
	 */
	private boolean isRoleAttribute(OpenIDAttribute attribute) {
		return SecurityConfig.AX_NAME_ROLE.equals(attribute.getName());
	}

}
