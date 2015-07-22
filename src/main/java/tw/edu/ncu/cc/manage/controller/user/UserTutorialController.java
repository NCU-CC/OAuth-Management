package tw.edu.ncu.cc.manage.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/tutorial")
public class UserTutorialController {
	
	
	/**
	 * 使用者說明
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "user/tutorial";
	}
}
