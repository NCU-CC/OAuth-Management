package tw.edu.ncu.cc.manage.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	private static final long serialVersionUID = 1L;
	
	@RequestMapping
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
