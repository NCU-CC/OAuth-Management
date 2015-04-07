package tw.edu.ncu.cc.manage.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static Logger logger = Logger.getLogger(MyFailureHandler.class);

	private static final String AFTER_LOGIN_URL = "/";
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException,
			ServletException {

		// not found in our database, visit first time
		if (openIdAuthenticationSuccesfullButUserIsNotRegistered(exception)) {
			logger.warn("new user", exception);
			redirectToOpenIdRegistrationUrl(request, response, exception);
		} else {
			super.onAuthenticationFailure(request, response, exception);
		}
	}

	private boolean openIdAuthenticationSuccesfullButUserIsNotRegistered(AuthenticationException exception) {
		return exception instanceof UsernameNotFoundException &&
			OpenIDAuthenticationStatus.SUCCESS.equals((openIdAuthenticationToken()).getStatus());
	}

	private OpenIDAuthenticationToken openIdAuthenticationToken() {
		return (OpenIDAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
	}
	
    private void redirectToOpenIdRegistrationUrl(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, AFTER_LOGIN_URL);
    }	
}
