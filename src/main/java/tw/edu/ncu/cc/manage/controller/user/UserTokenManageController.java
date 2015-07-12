package tw.edu.ncu.cc.manage.controller.user;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.edu.ncu.cc.manage.domain.AuthorizedToken;
import tw.edu.ncu.cc.manage.exception.NotAuthorizedException;
import tw.edu.ncu.cc.manage.service.IAuthorizedTokenService;
import tw.edu.ncu.cc.manage.service.IUserContextService;

/**
 * 使用者授權管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/user/token")
public class UserTokenManageController {

	@Autowired
	private IAuthorizedTokenService autorizedTokenService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * 已授權應用服務管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
				
		String username = this.userContextService.getCurrentUsername();
		List<AuthorizedToken> tokenList = this.autorizedTokenService.findAll(username);
		
		return new ModelAndView("user/token/list", "tokenList", tokenList);
	}

	
	/**
	 * 取消授權
	 * @param id
	 * @return
	 * @throws NotAuthorizedException 
	 */

	@RequestMapping(value = "/revoke", method = RequestMethod.GET)
	public String revoke(@RequestParam(value = "id", required = true) String id) throws NotAuthorizedException {
		
		String username = this.userContextService.getCurrentUsername();
		
		Optional<AuthorizedToken> token = this.autorizedTokenService.find(id);
		
		if (noSuchApp(token)) {
			String reason = String.format("嘗試存取不存在且未註冊的應用服務；username %s, tokenId %s .", username, id);
			throw new NotAuthorizedException(reason);
		}
		
		if (!hasPermission(token, username)) {
			String reason = String.format("嘗試存取不屬於自己的應用服務；username %s, tokenId %s .", username, id);
			throw new NotAuthorizedException(reason);
		}
		
		this.autorizedTokenService.revoke(token.get());

		return "redirect:../token/list";
	}

	private boolean noSuchApp(Optional<AuthorizedToken> appInfo) {
		return !appInfo.isPresent();
	}
	
	private boolean hasPermission(Optional<AuthorizedToken> token, String account) {
		return StringUtils.equals(token.get().getUser(), account);
	}
}
