package tw.edu.ncu.cc.manage.controller.developer;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.IUserContextService;
import tw.edu.ncu.cc.manage.service.IApplicationService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

/**
 * 開發者的app新增和更新secret
 * @author Yeh-Yung
 *
 */
@Controller
@RequestMapping("/developer/app")
public class DeveloperAppCreateController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeveloperAppCreateController.class);
	
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
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model, @ModelAttribute Application application) {
		
		application.setOwner(userContextService.getCurrentUsername());
		
		try {
			Optional<SecretIdApplication> appInfoId = this.appService.create(application);
			if (!appInfoId.isPresent()) {
				throw new Exception("Can\'t register new app.");
			}
			
		} catch (Exception | OAuthConnectionException e) {
			logger.warn("Can\t register new app.", e);
			model.addAttribute("errorTitle", "發生錯誤")
		     	 .addAttribute("errorContent", "新增時發生錯誤，請洽系統管理員");
		}

		return "developer/app/register";
	}
}