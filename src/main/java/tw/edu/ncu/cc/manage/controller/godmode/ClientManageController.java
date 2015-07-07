package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.service.IClientService;

/**
 * 應用服務管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/godmode/clientManage")
public class ClientManageController {

	@Autowired
	private IClientService clientService;
	
	/**
	 * 應用服務管理首頁
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "clientManage/list";
	}
	
	/**
	 * 應用服務管理搜尋
	 * @param model
	 * @param dto 一個Data Transfer Object，搜尋client的id、名稱、開發者和是否刪除
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "deleted")
	public String search(Model model, @ModelAttribute Client dto) {
		
		List<Client> clientList = this.clientService.search(dto);
		model.addAttribute("clientList", clientList);
		
		return "clientManage/list";
	}
}
