package tw.edu.ncu.cc.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import tw.edu.ncu.cc.manage.security.NoSuchUserRoleException;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

@ControllerAdvice
public class ExceptionHandlerController {

	private static final Logger logger = Logger.getLogger(ExceptionHandlerController.class);
	
	@ExceptionHandler(value = NoSuchUserRoleException.class)
	public ModelAndView noSuchUserRoleError(Exception exception) {
		logger.error(exception);
		return new ModelAndView("message", "messageContent", "目前僅限於在校生、教職員工及校友可使用本系統。");
	}

	@ExceptionHandler(value = IOException.class)
	public ModelAndView ioError(HttpServletRequest request, Exception exception) {
		logger.error(exception);
		return new ModelAndView("message", "messageContent", "系統存取錯誤。");
	}
	
	@ExceptionHandler(value = OAuthConnectionException.class)
	public ModelAndView oAuthConnectionError(Exception exception) {
		logger.error(exception);
		return new ModelAndView("message", "messageContent", "NCU OAuth發生錯誤。");
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception) {
		logger.error(exception);
		return new ModelAndView("message", "messageContent", "系統發生錯誤。");
	}
}
