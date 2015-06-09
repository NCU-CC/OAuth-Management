package tw.edu.ncu.cc.manage.controller.developer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/developer/client")
public class ClientTutorialController {
	
	/**
	 * 開發者說明
	 */
	@RequestMapping(value = "/tutorial", method = RequestMethod.GET)
	public String list(Model model) {
		return "developer/tutorial";
	}
}
