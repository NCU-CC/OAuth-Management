package tw.edu.ncu.cc.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import tw.edu.ncu.cc.manage.security.NoSuchUserRoleException;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value = NoSuchUserRoleException.class)
	public ModelAndView noSuchUserRoleError(HttpServletRequest request, Exception exception) {
		return new ModelAndView("message", "messageContent", "目前僅限於在校生、教職員工及校友可使用本系統。");
	}

	@ExceptionHandler(value = IOException.class)
	public ModelAndView ioError(HttpServletRequest request, Exception exception) {
		return new ModelAndView("message", "messageContent", "系統存取錯誤。");
	}
	
}
