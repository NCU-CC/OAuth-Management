package tw.edu.ncu.cc.manage.controller.user;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
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
import tw.edu.ncu.cc.manage.entity.User;
import tw.edu.ncu.cc.manage.entity.oauth.Application;
import tw.edu.ncu.cc.manage.service.IUserContextService;
import tw.edu.ncu.cc.manage.service.ITokenService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

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
	private IUserContextService userContextService;
	
	/**
	 * 已授權軟體管理
	 * @param model
	 * @return
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws MalformedURLException, IOException {
		
		
		String username = this.userContextService.getCurrentUsername();
		List<AccessToken> tokenList = tokenService.findAll(username);
		
		
		//List<AccessToken> tokenList = mockTokenList();
		model.addAttribute("tokenList", tokenList);
		
		return "user/token/list";
	}

	private List<AccessToken> mockTokenList() {
		
		AccessToken token1 = new AccessToken();
		token1.setLast_updated(new Timestamp(DateTime.now().getMillis()));
		token1.setUser("FAKE USER1");
		token1.setScope(new String[] {"FAKE_SCOPE11", "FAKE_SCOPE12"});
		token1.setId("FAKE ID1");
		token1.setApplication(mockApplication());
		
		AccessToken token2 = new AccessToken();
		token2.setLast_updated(new Timestamp(DateTime.now().getMillis()));
		token2.setUser("FAKE USER2");
		token2.setScope(new String[] {"FAKE_SCOPE12", "FAKE_SCOPE22"});
		token2.setId("FAKE ID2");
		token2.setApplication(mockApplication());
		
		return Arrays.asList(token1, token2);
	}
	
	private Application mockApplication() {
		Application app1 = new Application();
		app1.setId("AABBCCDDEEDD1");
		app1.setDescription("應用服務描述1");
		app1.setCallback("https://www.example.com/auth/callback1");
		app1.setName("應用服務1");
		app1.setOwner("H367245-1");
		app1.setUrl("https://www.example.com1");
		return app1;
	}
	
	/**
	 * 取消授權
	 * @param model
	 * @param id
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws OAuthConnectionException 
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(Model model, @RequestParam String tokenId) throws IOException, OAuthConnectionException {
		
		User user = this.userContextService.getCurrentUser();
		
		Optional<AccessToken> appInfo = this.tokenService.findById(tokenId);
		
		if (noSuchApp(appInfo)) {
			logger.warn("有可能是惡意行為，嘗試處理不存在且未註冊的app；User {}, tokenId {} .", user, tokenId);
			return "error/404";
		}
		
		if (!hasPermission(appInfo, user.getName())) {
			logger.warn("有可能是惡意行為，嘗試操作不屬於自己的app；User {}, tokenId {} .", user, tokenId);
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
