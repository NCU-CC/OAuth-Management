package tw.edu.ncu.cc.manage.controller.login;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.service.login.IAuthService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IAuthService authService;

	@RequestMapping("/")
	public String login() {
		String loginUrl = this.authService.getLoginString();
		if (StringUtils.isNotEmpty(loginUrl)) {
			return "login";
		}
		return "error";
	}
}
