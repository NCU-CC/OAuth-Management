package tw.edu.ncu.cc.manage.controller.developer;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.domain.ApiToken;
import tw.edu.ncu.cc.manage.domain.BlacklistClient;
import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.exception.NotAuthorizedException;
import tw.edu.ncu.cc.manage.service.IApiTokenService;
import tw.edu.ncu.cc.manage.service.IBlacklistClientService;
import tw.edu.ncu.cc.manage.service.IClientService;
import tw.edu.ncu.cc.manage.service.IUserContextService;

/**
 * 開發者的client清單
 * 
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/developer/client")
public class ClientController {

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private IClientService clientService;

	@Autowired
	private IApiTokenService apiTokenService;
	
	@Autowired
	private IUserContextService userContextService;
	
	@Autowired
	private IBlacklistClientService blacklistClientService;

	/**
	 * 開發者client清單首頁
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 *             Remote OAuth service down.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		String username = this.userContextService.getCurrentUsername();
		List<Client> clientList = this.clientService.findAll(username);

		model.addAttribute("clientList", clientList);

		return "developer/client/list";
	}

	/**
	 * 在清單按下「註冊新App」
	 * 
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String index() {
		return "developer/client/register";
	}

	/**
	 * 在註冊頁面按下「送出申請」
	 * 
	 * @param model
	 * @param application
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model, @Valid @ModelAttribute Client client) {

		client.setOwner(userContextService.getCurrentUsername());
		this.clientService.create(client);

		return "redirect:../client/list";
	}
	
	/**
	 * 應用服務詳細首頁
	 * @param model
	 * @param id
	 * @return
	 * @throws NotAuthorizedException 
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String getDetail(Model model, @PathVariable String id) throws NotAuthorizedException {
		
		Optional<Client> client = this.clientService.find(id);
		
		addClient(model, id, client);
		addBlackListIfExist(model, client);
		addApiToken(model, client);

		return "developer/client/detail";
	}
	
	private void addClient(Model model, String id, Optional<Client> client) throws NotAuthorizedException {
		String username = this.userContextService.getCurrentUsername();
		validateClient(client, username);
		model.addAttribute("client", client.get());		
	}

	private void addBlackListIfExist(Model model, Optional<Client> client) {
		this.blacklistClientService
		.search(client.get())
		.stream()
		.findAny()
		.ifPresent(
				b -> model.addAttribute("isInBlacklist", true)
		);
	}
	
	private void addApiToken(Model model, Optional<Client> client) {
		ApiToken apiToken = this.apiTokenService.createOrFindByClient(client.get().getId());
		model.addAttribute("apiToken", apiToken);
	}
	
	/**
	 * 在詳細頁面按下「更新」
	 * @param model
	 * @param editedClient
	 * @return
	 * @throws NotAuthorizedException 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postDetail(@ModelAttribute Client editedClient) throws NotAuthorizedException {
		
		//TODO 若已被加入黑名單，則不得更新
		String username = this.userContextService.getCurrentUsername();
		Optional<Client> oldClient = this.clientService.find(editedClient.getId());
		validateClient(oldClient, username);

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
		validateClient(client, username);
		
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
		validateClient(client, username);
		
		this.clientService.refreshSecret(id);
		
		return "redirect:../client/detail?id=" + id;
	}
	
	/**
	 * 確認有權限處理{@link Client}
	 * @param client
	 * @param username
	 * @return
	 * @throws NotAuthorizedException 
	 */
	protected void validateClient(Optional<Client> client, String username) throws NotAuthorizedException {
		
		if (!client.isPresent()) {
			logger.warn("嘗試存取不存在的" + Client.class.getSimpleName());
			throw new NotAuthorizedException("未經允許的操作");
		}
		
		if (this.userContextService.getCurrentUser().isAdmin()) {
			return;
		}
		
		if (!client.get().isOwned(username)) {
			logger.warn("嘗試存取不屬於自己的" + Client.class.getSimpleName());
			throw new NotAuthorizedException("未經允許的操作");
		}
		
		if (client.get().isDeleted()) {
			logger.warn("嘗試存取已刪除的" + Client.class.getSimpleName());
			throw new NotAuthorizedException("未經允許的操作");			
		}
	}

	/**
	 * 在編輯頁面按下「更新API Token」
	 * @param model
	 * @param id
	 * @return
	 * @throws NotAuthorizedException 
	 */
	@RequestMapping(value = "/apiToken", method = RequestMethod.GET)
	public String refreshApiToken(Model model, @RequestParam(value = "d", required = true) String token) throws NotAuthorizedException {
		
		String username = userContextService.getCurrentUsername();
		
		Optional<ApiToken> apiToken = this.apiTokenService.find(token);
		
		Optional<Client> client = this.clientService.find(apiToken.get().getClient_id());
		validateClient(client, username);
		
		this.apiTokenService.refresh(apiToken.get().getId());
		
		return "redirect:../client/detail?id=" + client.get().getId();
	}
	
}
