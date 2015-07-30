package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tw.edu.ncu.cc.manage.domain.BlacklistClient;
import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.service.IBlacklistClientService;

/**
 * 應用服務黑名單管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/godmode/blacklist/client")
public class ClientBlackListController {

	@Autowired
	private IBlacklistClientService blacklistClientService;
	
	/**
	 * 應用服務黑名單首頁
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "clientBlacklist/list";
	}
	
	/**
	 * 應用服務黑名單搜尋
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "deleted")
	public ModelAndView search(@ModelAttribute Client dto) {
		
		List<BlacklistClient> clientList = this.blacklistClientService.search(dto);
		
		return new ModelAndView("clientBlacklist/list", "clientList", clientList);
	}
	
	/**
	 * 新增應用服務黑名單頁面
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "clientBlacklist/create";
	}
	
	/**
	 * 在新增頁面按下「新增」
	 * @param client
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSubmit(@ModelAttribute BlacklistClient client) {
		
		this.blacklistClientService.create(client);
		
		return "redirect:../client?deleted=false&id=" + client.getClient_id();
	}
	
	//TODO 編輯功能
	
	/**
	 * 在搜尋後，按下「刪除」
	 * @return
	 */
	@RequestMapping(value = "/delete/{clientId}", method = RequestMethod.GET)
	public String delete(@PathVariable String clientId) {

		BlacklistClient blacklistClient = this.blacklistClientService.find(clientId).get();
		this.blacklistClientService.remove(blacklistClient);
		
		return "redirect:..";
	}
	
}
