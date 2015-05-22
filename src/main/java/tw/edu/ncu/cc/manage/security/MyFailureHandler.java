package tw.edu.ncu.cc.manage.security;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import tw.edu.ncu.cc.manage.config.SecurityConfig;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.enums.RoleEnum;
import tw.edu.ncu.cc.manage.service.IPersonService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

import com.google.inject.internal.Lists;

@Component
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static Logger logger = LoggerFactory.getLogger(MyFailureHandler.class);

	private static final String AFTER_AUTHENTICATE_URL = "/";

	private static final String NOT_AUTHORIZED_URL = "/error/401";

	private static final String INTERNAL_SERVER_ERROR = "/error/500";

	@Autowired
	private IPersonService personService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		if (noSuchRoleInOpenIDAuthentication(exception)) {
			logger.warn("沒有符合的 OpenID Roles");
			getRedirectStrategy().sendRedirect(request, response, NOT_AUTHORIZED_URL);
			return;
		}

		if (openIdAuthenticationSuccessfulButUserIsNotRegistered(exception)) {
			logger.info("OpenID 驗證成功，但使用者未註冊");
			Person person;
			try {
				person = createUserInfo(request, response, exception);
				addUsernameToSession(person);
				getRedirectStrategy().sendRedirect(request, response, AFTER_AUTHENTICATE_URL);
			} catch (OAuthConnectionException e) {
				getRedirectStrategy().sendRedirect(request, response, INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return;
		} else {
			logger.info("不是OpenID驗證錯誤，就是其他問題", exception);
			getRedirectStrategy().sendRedirect(request, response, NOT_AUTHORIZED_URL);
			return;
		}
	}

	private boolean noSuchRoleInOpenIDAuthentication(AuthenticationException exception) {
		return exception instanceof NoSuchUserRoleException;
	}

	private boolean openIdAuthenticationSuccessfulButUserIsNotRegistered(AuthenticationException exception) {
		return exception instanceof OpenIDUserNotFoundException && openIdAuthenticationToken(exception) instanceof OpenIDAuthenticationToken
				&& OpenIDAuthenticationStatus.SUCCESS.equals(openIdAuthenticationToken(exception).getStatus());
	}

	private OpenIDAuthenticationToken openIdAuthenticationToken(AuthenticationException exception) {
		return ((OpenIDUserNotFoundException) exception).getOpenIDAuthenticationToken();
	}

	private Person createUserInfo(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException,
			OAuthConnectionException {

		OpenIDAuthenticationToken token = openIdAuthenticationToken(exception);
		logger.debug("使用者 OpenID token: {}", token);
		
		String account = StringUtils.substringAfterLast((String) token.getPrincipal(), "/");

		//this.personService.createUserOnOAuthService(account);
		List<String> roles = grepRoles(token);
		Person newPerson = createPerson(request, account, roles);
		this.personService.create(newPerson);
		return newPerson;
	}

	private List<String> grepRoles(OpenIDAuthenticationToken token) {
		List<OpenIDAttribute> attributes = token.getAttributes();
		for (OpenIDAttribute attribute : attributes) {
			if (isRoleAttribute(attribute)) {
				logger.debug("使用者 OpenID roles: {}", attribute);
				String roles = attribute.getValues().get(0);
				return Lists.newArrayList(roles.split(","));
			}
		}
		return Collections.emptyList();
	}

	/**
	 * 這個attribute是屬性role
	 * @param attribute
	 * @return
	 */
	private boolean isRoleAttribute(OpenIDAttribute attribute) {
		return SecurityConfig.AX_NAME_ROLE.equals(attribute.getName());
	}
	
	private Person createPerson(HttpServletRequest request, String id, List<String> roles) {
		Person person = new Person(id);
		person.setDateCreated(DateTime.now().toDate());
		person.setDateLastActived(DateTime.now().toDate());
		person.setDeleted(false);
		person.setIpCreated(request.getRemoteAddr());
		person.setIpLastActived(request.getRemoteAddr());
		person.setType(RoleEnum.matchOne(roles));
		return person;
	}

	private void addUsernameToSession(Person person) {
		RequestContextHolder.getRequestAttributes().setAttribute("username", person.getAccount(), RequestAttributes.SCOPE_SESSION);
	}
}
