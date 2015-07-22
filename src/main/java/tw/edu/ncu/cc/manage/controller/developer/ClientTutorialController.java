package tw.edu.ncu.cc.manage.controller.developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tw.edu.ncu.cc.manage.domain.ApiToken;
import tw.edu.ncu.cc.manage.service.IApiTokenService;

@Controller
@RequestMapping("/developer/tutorial")
public class ClientTutorialController {
	
	@Autowired
	private IApiTokenService apiTokenService;
	
	/**
	 * 開發者說明
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		List<ApiToken> list = this.apiTokenService.findAllByClient("8RnbKwp8RjZeGLkx");
		return new ModelAndView("developer/tutorial", "list", list);
	}
}
