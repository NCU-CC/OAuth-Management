package tw.edu.ncu.cc.manage.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static final long serialVersionUID = 1L;


	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
