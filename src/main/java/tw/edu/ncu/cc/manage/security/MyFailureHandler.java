package tw.edu.ncu.cc.manage.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static Logger logger = LoggerFactory.getLogger(MyFailureHandler.class);

	private static final String NOT_AUTHORIZED_URL = "/error/401";

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		if (noSuchRoleInOpenIDAuthentication(exception)) {
			logger.warn("沒有符合的 OpenID Roles");
			getRedirectStrategy().sendRedirect(request, response, NOT_AUTHORIZED_URL);
			return;
		}

		logger.info("OpenID驗證錯誤", exception);
		getRedirectStrategy().sendRedirect(request, response, NOT_AUTHORIZED_URL);
		return;
	}

	private boolean noSuchRoleInOpenIDAuthentication(AuthenticationException exception) {
		return exception instanceof NoSuchUserRoleException;
	}
}
