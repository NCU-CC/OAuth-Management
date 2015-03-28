package tw.edu.ncu.cc.manage.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.service.login.IAuthService;

@Controller
public class AuthController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IAuthService authService;

	@RequestMapping("/auth")
	public String auth(HttpServletRequest request, HttpSession session) {
		String studentId = checkOpenId(request);
		if (StringUtils.isNotEmpty(studentId)) {
			session.setAttribute("tmpId", studentId);
			return "redirect:logined";
		}
		// 403 forbidden
		return "error";
	}

	private String checkOpenId(HttpServletRequest request) {
		boolean isChecked = this.authService.isLoginSuccess(request);
		if (isChecked) {
			return this.authService.getIdentityId(request);
		}
		return null;
	}
}
