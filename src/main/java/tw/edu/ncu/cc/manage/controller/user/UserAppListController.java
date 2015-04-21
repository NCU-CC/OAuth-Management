package tw.edu.ncu.cc.manage.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.IApplicationContextService;
import tw.edu.ncu.cc.manage.service.ITokenService;
import tw.edu.ncu.cc.manage.utils.SystemConstant;

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

	@RequestMapping("/cancel")
	public String cancel(Model model, @RequestParam String id, HttpServletRequest request) {
//		String userId = PersonUtil.getStudentId(request);
//		AccessToken appInfo = service.getTokenbyTokenId(id);
//		if (appInfo == null) {
//			// TODO setErrorMessage("找無此APP", "無法找到該APP，可以是因為已被刪除");
//		} else if (!service.isAllowToAccess(appInfo, userId)) {
//			// TODO setErrorMessage("您無權限存取該APP", "您無權限存取該APP，您並非是此APP的傭有者");
//		}
//		model.addAttribute("appInfo", appInfo);
//		
//		if (appInfo == null) {
//			appInfo = service.removeToken(id);
//			if (appInfo == null) {
//				//return "authorizedappdeletefail";
//				return "common/message";
//			}
//			// return "authorizedappdeletesuc";
//			return "common/message";
//		}
//		// return "authorizedappdeletefail";
		return "common/message";
	}
}
