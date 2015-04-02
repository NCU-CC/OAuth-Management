package tw.edu.ncu.cc.manage.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.manage.config.SecurityConfig;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.login.IPersonService;

@Component
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static Logger logger = Logger.getLogger(MyFailureHandler.class);

	private static final String AFTER_AUTHENTICATE_URL = "/";
	
	@Autowired
	private IPersonService service;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException,
			ServletException {

		if (noSuchRoleInOpenIDAuthentication(exception)) {
			super.onAuthenticationFailure(request, response, exception);
		}
		
		if (openIdAuthenticationSuccesfullButUserIsNotRegistered(exception)) {
			createOrUpdateUserInfo(request, response);
		} else {
			super.onAuthenticationFailure(request, response, exception);
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
	
    private void createOrUpdateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    	OpenIDAuthenticationToken token = openIdAuthenticationToken();
    	String account = ((String)token.getPrincipal()).substring(SecurityConfig.AX_NAME_ROLE.length());
    	
		Optional<Person> person = this.service.findByAccount(account);
		
		if (person.isPresent()) {
			this.service.refresh(person.get(), request.getRemoteAddr());
		} else {
			this.service.createUserOnRemoteServer(account);
			Person newPerson = this.service.getNewLoginPerson(request, account);
			this.service.create(newPerson);
		}
    	
    	
    	DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, AFTER_AUTHENTICATE_URL);
    }	
}
