package tw.edu.ncu.cc.manage.controller.developer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.edu.ncu.cc.manage.entity.oauth.Application;
import tw.edu.ncu.cc.manage.service.IApplicationService;
import tw.edu.ncu.cc.manage.service.IUserContextService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

/**
 * 開發者的app新增和更新secret
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/developer/app")
public class DeveloperAppCreateController {
	
	@Autowired
	private IApplicationService appService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * 在清單按下「註冊新App」
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String index() {
		return "developer/app/register";
	}

	/**
	 * 在註冊頁面按下「送出申請」
	 * @param model
	 * @param application
	 * @return
	 * @throws OAuthConnectionException OAuth Service 發生錯誤
	 * @throws Exception 
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model, @ModelAttribute Application application) throws OAuthConnectionException, Exception {
		
		application.setOwner(userContextService.getCurrentUsername());

		Optional<Application> appInfoId = this.appService.create(application);
		
		if (!appInfoId.isPresent()) {
			throw new Exception("Can\'t register new app.");
		}

		return "developer/app/register";
	}
}