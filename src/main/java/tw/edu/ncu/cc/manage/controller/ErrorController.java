package tw.edu.ncu.cc.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 顯示錯誤頁面
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
	
	@RequestMapping("/401")
	public String notAuthorized() {
		return "error/401";
	}
	
	@RequestMapping("/404")
	public String notFound() {
		return "error/404";
	}
	
	@RequestMapping("/500")
	public String internalServerError() {
		return "error/500";
	}
}
