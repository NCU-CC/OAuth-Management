package tw.edu.ncu.cc.manage.controller.blacklist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/blacklist")
public class BlackListController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "blacklist/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "blacklist/create";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "blacklist/edit";
	}
	
}
