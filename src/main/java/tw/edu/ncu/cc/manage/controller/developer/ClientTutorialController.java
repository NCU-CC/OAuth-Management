package tw.edu.ncu.cc.manage.controller.developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.edu.ncu.cc.manage.domain.ApiToken;
import tw.edu.ncu.cc.manage.service.IApiTokenService;

@Controller
@RequestMapping("/developer/client")
public class ClientTutorialController {
	
	@Autowired
	private IApiTokenService apiTokenService;
	
	/**
	 * 開發者說明
	 */
	@RequestMapping(value = "/tutorial", method = RequestMethod.GET)
	public String list(Model model) {
		List<ApiToken> list = this.apiTokenService.findAllByClient("8RnbKwp8RjZeGLkx");
		model.addAttribute("list", list);
		return "developer/tutorial";
	}
}
