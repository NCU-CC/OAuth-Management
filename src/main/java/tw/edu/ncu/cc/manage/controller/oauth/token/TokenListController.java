package tw.edu.ncu.cc.manage.controller.oauth.token;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.entity.oauth.token.AccessToken;
import tw.edu.ncu.cc.manage.service.oauth.ITokenService;
import tw.edu.ncu.cc.manage.util.PersonUtil;

@Controller
@RequestMapping("/")
public class TokenListController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITokenService service;

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) throws Exception {
		// TODO createTokenForGet();
		String userId = PersonUtil.getStudentId(request);
		List<AccessToken> tokenList = service.getAllTokensByUserId(userId);
		model.addAttribute("tokenList", tokenList);
		return "authorizedapplist";
	}

	@RequestMapping("/cancel")
	public String cancel(Model model, @RequestParam String id, HttpServletRequest request) {
		String userId = PersonUtil.getStudentId(request);
		AccessToken appInfo = service.getTokenbyTokenId(id);
		if (appInfo == null) {
			// TODO setErrorMessage("找無此APP", "無法找到該APP，可以是因為已被刪除");
		} else if (!service.isAllowToAccess(appInfo, userId)) {
			// TODO setErrorMessage("您無權限存取該APP", "您無權限存取該APP，您並非是此APP的傭有者");
		}
		model.addAttribute("appInfo", appInfo);
		
		if (appInfo == null) {
			appInfo = service.removeToken(id);
			if (appInfo == null) {
				return "authorizedappdeletefail";
			}
			return "authorizedappdeletesuc";
		}
		return "authorizedappdeletefail";
	}
}
