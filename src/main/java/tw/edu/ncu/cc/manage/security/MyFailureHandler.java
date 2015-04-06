package tw.edu.ncu.cc.manage.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.manage.config.SecurityConfig;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.entity.RoleEnum;
import tw.edu.ncu.cc.manage.service.login.IPersonService;

@Component
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static Logger logger = Logger.getLogger(MyFailureHandler.class);

	private static final String AFTER_AUTHENTICATE_URL = "/";
	
	private static final String NOT_AUTHORIZED_URL = "/error/401";
	
	@Autowired
	private IPersonService personService;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException,
			ServletException {

		if (noSuchRoleInOpenIDAuthentication(exception)) {
			logger.debug("No such role.");
			getRedirectStrategy().sendRedirect(request, response, NOT_AUTHORIZED_URL);
			return;
		}
		
		if (openIdAuthenticationSuccesfullButUserIsNotRegistered(exception)) {
			logger.debug("Openid authentication succesfull but user is not registered.");
			createOrUpdateUserInfo(request, response);
	        getRedirectStrategy().sendRedirect(request, response, AFTER_AUTHENTICATE_URL);
	        return;
		} else {
			logger.debug("Either openid authentication fail or other type exception happened.", exception);
			getRedirectStrategy().sendRedirect(request, response, NOT_AUTHORIZED_URL);
			return;
		}
	}

	private boolean noSuchRoleInOpenIDAuthentication(AuthenticationException exception) {
		return exception instanceof NoSuchUserRoleException;
	}
	
	private boolean openIdAuthenticationSuccesfullButUserIsNotRegistered(AuthenticationException exception) {
		return exception instanceof UsernameNotFoundException &&
			OpenIDAuthenticationStatus.SUCCESS.equals((openIdAuthenticationToken()).getStatus());
	}

	private OpenIDAuthenticationToken openIdAuthenticationToken() {
		return (OpenIDAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
	}
	
    @SuppressWarnings("unchecked")
	private void createOrUpdateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    	OpenIDAuthenticationToken token = openIdAuthenticationToken();
    	String account = ((String)token.getPrincipal()).substring(SecurityConfig.AX_NAME_ROLE.length());
     	
		this.personService.createUserOnRemoteServer(account);
		List<String> roles = (List<String>) token.getDetails();
		Person newPerson = createPerson(request, account, roles);
		this.personService.create(newPerson);

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
}
