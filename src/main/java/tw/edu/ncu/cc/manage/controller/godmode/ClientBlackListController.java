package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		return "blacklist/client/list";
	}
	
	/**
	 * 應用服務黑名單搜尋
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "deleted")
	public String search(Model model, @ModelAttribute Client dto) {
		
		List<BlacklistClient> clientList = this.blacklistClientService.search(dto);
		
		model.addAttribute("clientList", clientList);
		
		return "blacklist/client/list";
	}
	
	/**
	 * 新增應用服務黑名單頁面
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "blacklist/client/create";
	}
	
	/**
	 * 在「新增應用服務黑名單」頁面按下新增
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSubmit(@ModelAttribute BlacklistClient client) {
		
		client = this.blacklistClientService.create(client);
		
		return "redirect:../blacklist/client?id=" + client.getClient().getId();
	}
	
	// 編輯黑名單
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "blacklist/client/edit";
	}
	
	// 刪除黑名單
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "blacklist/client/list";
	}
	
}
