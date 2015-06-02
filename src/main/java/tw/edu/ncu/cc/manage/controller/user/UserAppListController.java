package tw.edu.ncu.cc.manage.controller.user;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.domain.AccessToken;
import tw.edu.ncu.cc.manage.exception.NotAuthorizedException;
import tw.edu.ncu.cc.manage.service.ITokenService;
import tw.edu.ncu.cc.manage.service.IUserContextService;

/**
 * 使用者管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/user/app")
public class UserAppListController {

	@Autowired
	private ITokenService tokenService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * 已授權應用服務管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
				
		String username = this.userContextService.getCurrentUsername();
		List<AccessToken> tokenList = this.tokenService.findAll(username);
		
		model.addAttribute("tokenList", tokenList);
		
		return "user/token/list";
	}

	
	/**
	 * 取消授權
	 * @param model
	 * @param id
	 * @return
	 * @throws NotAuthorizedException 
	 */

	@RequestMapping(value = "/revoke", method = RequestMethod.GET)
	public String revoke(Model model, @RequestParam(value = "id", required = true) String id) throws NotAuthorizedException {
		
		String username = this.userContextService.getCurrentUsername();
		
		Optional<AccessToken> token = this.tokenService.find(id);
		
		if (noSuchApp(token)) {
			String reason = String.format("嘗試處理不存在且未註冊的應用服務；username %s, tokenId %s .", username, id);
			throw new NotAuthorizedException(reason);
		}
		
		if (!hasPermission(token, username)) {
			String reason = String.format("嘗試操作不屬於自己的應用服務；username %s, tokenId %s .", username, id);
			throw new NotAuthorizedException(reason);
		}
		
		this.tokenService.revoke(token.get());

		return "redirect:../app/list";
	}

	private boolean noSuchApp(Optional<AccessToken> appInfo) {
		return !appInfo.isPresent();
	}
	
	private boolean hasPermission(Optional<AccessToken> token, String account) {
		return StringUtils.equals(token.get().getUser(), account);
	}
}
