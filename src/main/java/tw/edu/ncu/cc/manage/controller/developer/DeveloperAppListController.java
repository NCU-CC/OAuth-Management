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
 * 開發者的app清單
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/developer/app")
public class DeveloperAppListController {
	
	@Autowired
	private IClientService clientService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * 開發者app清單首頁
	 * @param model
	 * @return
	 * @throws IOException Remote OAuth service down.
	 */
	@RequestMapping("/list")
	public String list(Model model) throws IOException {
		
		
		String username = this.userContextService.getCurrentUsername();
		List<Client> applicationList = this.clientService.findAll(username);
		
		 		model.addAttribute("appList", applicationList);
		
		return "developer/app/list";
	}
	
}
