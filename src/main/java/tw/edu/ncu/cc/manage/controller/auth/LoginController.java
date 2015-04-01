package tw.edu.ncu.cc.manage.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.service.login.IAuthService;

@Controller
public class LoginController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IAuthService authService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
