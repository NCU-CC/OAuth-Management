package tw.edu.ncu.cc.manage.controller.developer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/developer/tutorial")
public class ClientTutorialController {
	
	/**
	 * 開發者說明
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "developer/tutorial";
	}
}
