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
@RequestMapping("/developer/client")
public class ClientTutorialController {
	
	@Autowired
	private IApiTokenService apiTokenService;
	
	/**
	 * 開發者說明
	 */
	@RequestMapping(value = "/tutorial", method = RequestMethod.GET)
	public ModelAndView list() {
		List<ApiToken> list = this.apiTokenService.findAllByClient("8RnbKwp8RjZeGLkx");
		return new ModelAndView("developer/tutorial", "list", list);
	}
	/**
	 * TODO
	 * 1. api黑名單說明(開發者被加進黑名單後，其下的CLIENT都會黑名單)
	 * 2. api token和CLIENT_ID建議的模式 (api gateway)
	 */
}
