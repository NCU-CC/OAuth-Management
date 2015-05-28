package tw.edu.ncu.cc.manage.controller.developer;

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
import tw.edu.ncu.cc.manage.exception.NotAuthorizedException;
import tw.edu.ncu.cc.manage.service.IClientService;
import tw.edu.ncu.cc.manage.service.IUserContextService;

/**
 * 開發者app編輯
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/developer/client")
public class ClientEditController {

	private static final Logger logger = LoggerFactory.getLogger(ClientEditController.class);
	
	@Autowired
	private IClientService clientService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * 應用服務編輯首頁
	 * @param model
	 * @param id
	 * @return
	 * @throws NotAuthorizedException 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(Model model, @RequestParam(value = "id", required = true) String id) throws NotAuthorizedException {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<Client> client = this.clientService.find(id);
		if (!isAuthorized(client, username)) {
			throw new NotAuthorizedException("未經允許的操作");
		}
		
		model.addAttribute("client", client.get());
		
		return "developer/client/edit";
	}
	

	/**
	 * 在修改頁面按下「更新」
	 * @param model
	 * @param editedClient
	 * @return
	 * @throws NotAuthorizedException 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(@ModelAttribute Client editedClient) throws NotAuthorizedException {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<Client> oldClient = this.clientService.find(editedClient.getId());
		if (!isAuthorized(oldClient, username)) {
			throw new NotAuthorizedException("未經允許的操作");
		}

		editedClient.setId(oldClient.get().getId());
		editedClient.setOwner(username);
		
		this.clientService.update(editedClient);

		return "redirect:../client/list";
	}

	
	/**
	 * 按下「刪除App」
	 * @param model
	 * @param id
	 * @return
	 * @throws NotAuthorizedException 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) String id) throws NotAuthorizedException {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<Client> client = this.clientService.find(id);
		if (!isAuthorized(client, username)) {
			throw new NotAuthorizedException("未經允許的操作");
		}
		
		this.clientService.remove(client.get());

		return "redirect:../client/list";
	}
	
	/**
	 * 在編輯頁面按下「更新secret」
	 * @param model
	 * @param id
	 * @return
	 * @throws NotAuthorizedException 
	 */
	@RequestMapping(value = "/secret", method = RequestMethod.GET)
	public String refreshSecret(Model model, @RequestParam(value = "id", required = true) String id) throws NotAuthorizedException {
		
		String username = userContextService.getCurrentUsername();
		
		Optional<Client> client = this.clientService.find(id);
		if (!isAuthorized(client, username)) {
			throw new NotAuthorizedException("未經允許的操作");
		}
		
		this.clientService.refreshSecret(id);
		
		model.addAttribute("messageTitle", "更新成功")
	     	 .addAttribute("messageContent", "更新secret成功");
		
		return "common/message";
	}
	
	/**
	 * 有權限處理{@link Client}
	 * @param client
	 * @param username
	 * @return
	 */
	protected boolean isAuthorized(Optional<Client> client, String username) {
		if (!client.isPresent()) {
			logger.warn("嘗試操作不存在的" + Client.class.getSimpleName());
			return false;
		}
		
		if (!client.get().isOwned(username)) {
			logger.warn("嘗試操作不屬於自己的" + Client.class.getSimpleName());
			return false;
		}
		return true;
	}
}
