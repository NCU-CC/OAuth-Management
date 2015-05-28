package tw.edu.ncu.cc.manage.controller.developer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.service.IClientService;
import tw.edu.ncu.cc.manage.service.IUserContextService;

/**
 * 開發者app編輯
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/developer/app")
public class DeveloperAppEditController {

	private static final Logger logger = LoggerFactory.getLogger(DeveloperAppEditController.class);
	
	@Autowired
	private IClientService clientService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * app編輯首頁
	 * @param model
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(Model model, @RequestParam(value = "id", required = true) String id) throws MalformedURLException, IOException {
		

		String username = this.userContextService.getCurrentUsername();
		Optional<Client> client = this.clientService.find(id);
		if (!isAuthorized(client, username)) {
			return "error/404";
		}

		
		model.addAttribute("client", client.get());
		
		return "developer/app/edit";
	}
	

	/**
	 * 按下「更新App」
	 * @param model
	 * @param editedClient
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(Model model, @ModelAttribute Client editedClient) {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<Client> oldApplication = this.clientService.find(editedClient.getId());
		if (!isAuthorized(oldApplication, username)) {
			return "error/404";
		}

		copySubmitValue(editedClient, oldApplication.get());
		
		this.clientService.update(editedClient);

		
		model.addAttribute("messageTitle", "修改成功")
		     .addAttribute("messageContent", "app修改成功");
		
		return "common/message";
	}
	
	private void copySubmitValue(Client from, Client to) {
		to.setId(from.getId());
		to.setOwner(from.getOwner());
	}
	
	/**
	 * 按下「刪除App」
	 * @param model
	 * @param id
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws OAuthConnectionException 
	 */
	@RequestMapping("/delete")
	public String delete(Model model, @RequestParam(value = "id", required = true) String id) {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<Client> client = this.clientService.find(id);
		if (!isAuthorized(client, username)) {
			return "error/404";
		}
		
		this.clientService.remove(client.get());

		model.addAttribute("messageTitle", "刪除成功")
	         .addAttribute("messageContent", "app刪除成功");
		
		return "common/message";
	}
	
	/**
	 * 在編輯頁面按下「更新secret」
	 * @param model
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws OAuthConnectionException 
	 */
	@RequestMapping("/secret")
	public String refreshSecret(Model model, @RequestParam(value = "id", required = true) String id) {
		
		String username = userContextService.getCurrentUsername();
		
		Optional<Client> client = this.clientService.find(id);
		if (!isAuthorized(client, username)) {
			return "error/404";
		}
		
		this.clientService.refreshSecret(id);
		
		model.addAttribute("messageTitle", "更新成功")
	     	 .addAttribute("messageContent", "更新secret成功");
		
		return "common/message";
	}
	
	/**
	 * 是有權限處理的{@link IdApplication}
	 * @param client
	 * @param username
	 * @return
	 */
	protected boolean isAuthorized(Optional<Client> client, String username) {
		if (!client.isPresent()) {
			logger.warn("Potential hacker, trying to edit non exist app.");
			return false;
		}
		
		if (!client.get().isOwned(username)) {
			logger.warn("Potential hacker, trying to edit non-authorized app.");
			return false;
		}
		return true;
	}
}
