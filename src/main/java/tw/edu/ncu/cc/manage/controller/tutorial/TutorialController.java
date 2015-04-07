package tw.edu.ncu.cc.manage.controller.tutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tutorial")
public class TutorialController {

	@RequestMapping(value = "/developer", method = RequestMethod.GET)
	public String developer() {
		return "tutorial/developer";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		return "tutorial/user";
	}
}
