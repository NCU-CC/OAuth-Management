package tw.edu.ncu.cc.manage.controller.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.service.IClientService;
import tw.edu.ncu.cc.manage.service.IUserContextService;

/**
 * 開發者的app新增和更新secret
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/developer/app")
public class DeveloperAppCreateController {
	
	@Autowired
	private IClientService clientService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * 在清單按下「註冊新App」
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String index() {
		return "developer/app/register";
	}

	/**
	 * 在註冊頁面按下「送出申請」
	 * @param model
	 * @param application
	 * @return
	 * @throws OAuthConnectionException OAuth Service 發生錯誤
	 * @throws Exception 
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model, @ModelAttribute Client client) {
		
		client.setOwner(userContextService.getCurrentUsername());

		this.clientService.create(client);
		
		return "developer/app/register";
	}
}