package tw.edu.ncu.cc.manage.controller.developer;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.service.IClientService;
import tw.edu.ncu.cc.manage.service.IUserContextService;

/**
 * 開發者的client清單
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/developer/client")
public class ClientListController {
	
	@Autowired
	private IClientService clientService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * 開發者client清單首頁
	 * @param model
	 * @return
	 * @throws IOException Remote OAuth service down.
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		
		String username = this.userContextService.getCurrentUsername();
		List<Client> clientList = this.clientService.findAll(username);
		
		model.addAttribute("clientList", clientList);
		
		return "developer/client/list";
	}
	
}
