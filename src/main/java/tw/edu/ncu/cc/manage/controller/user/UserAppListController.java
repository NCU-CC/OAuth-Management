package tw.edu.ncu.cc.manage.controller.user;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.IApplicationContextService;
import tw.edu.ncu.cc.manage.service.ITokenService;

/**
 * 使用者管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/user/app")
public class UserAppListController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAppListController.class);
	
	@Autowired
	private ITokenService tokenService;

	@Autowired
	private IApplicationContextService applicationContextService;
	
	/**
	 * 已授權軟體管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		Person user = this.applicationContextService.getCurrentUser();
		String userAccount = user.getAccount();
		
		List<AccessToken> tokenList = tokenService.findAll(userAccount);
		model.addAttribute("tokenList", tokenList);
		
		return "user/token/list";
	}

	/**
	 * 取消授權
	 * @param model
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(Model model, @RequestParam String tokenId) {
		
		Person user = this.applicationContextService.getCurrentUser();
		String userAccount = user.getAccount();
		
		Optional<AccessToken> appInfo = this.tokenService.findById(tokenId);
		
		if (noSuchApp(appInfo)) {
			logger.warn("Protential hacker, trying to access nonexist app. User {}, tokenId {} .", user, tokenId);
			return "error/404";
		}
		
		if (!hasPermission(appInfo, userAccount)) {
			logger.warn("Protential hacker, trying to access non-authorized app. User {}, tokenId {} .", user, tokenId);
			return "error/404";
		}
		
		this.tokenService.remove(appInfo.get());
		
		model.addAttribute("messageTitlle", "刪除成功")
		     .addAttribute("messageContent", "已成功刪除授權");

		return "common/message";
	}

	private boolean noSuchApp(Optional<AccessToken> appInfo) {
		return !appInfo.isPresent();
	}
	
	private boolean hasPermission(Optional<AccessToken> token, String account) {
		return tokenService.hasPermission(token.get(), account);
	}
}
