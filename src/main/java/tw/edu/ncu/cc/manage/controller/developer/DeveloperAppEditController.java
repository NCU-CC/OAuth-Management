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

import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.IApplicationService;
import tw.edu.ncu.cc.manage.service.IUserContextService;

/**
 * 開發者app編輯
 * @author Yeh-Yung
 *
 */
@Controller
@RequestMapping("/developer/app")
public class DeveloperAppEditController {

	private static final Logger logger = LoggerFactory.getLogger(DeveloperAppEditController.class);
	
	@Autowired
	private IApplicationService appService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * app編輯首頁
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(Model model, @RequestParam(value = "id", required = true) String id) {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<IdApplication> application = this.appService.findById(id);
		
		if (!application.isPresent()) {
			logger.warn("Potential hacker, trying to edit non exist app.");
			return "error/404";
		}
		
		if (!this.appService.isAllowToAccess(application.get(), username)) {
			logger.warn("Potential hacker, trying to edit non-authorized app.");
			return "error/404";
		}
		
		model.addAttribute("application", application);
		
		return "developer/app/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(@ModelAttribute IdApplication editedApplication) {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<IdApplication> oldApplication = this.appService.findById(editedApplication.getId());
		
		if (!oldApplication.isPresent()) {
			logger.warn("Potential hacker, trying to edit non exist app.");
			return "error/404";
		}
		
		if (!this.appService.isAllowToAccess(oldApplication.get(), username)) {
			logger.warn("Potential hacker, trying to edit non-authorized app.");
			return "error/404";
		}
		
		return "developer/app/edit";
//		IdApplication old = getAPPbyAPPId(id);
//		//if (isAccessible) {
//			//IdApplication appInfo = copyAPPInfo(appInfo, old);
//			IdApplication appInfo = new IdApplication();
//			try {
//				Application app = this.appService.updateAPP(appInfo);
//				if (app == null) {
//					//warningTitle = "有些錯誤";
//					//warningContent = "處理有些錯誤";
//					return "developer/app/edit";
//				}
//			} catch (OAuthConnectionException e) {
//				//warningTitle = "有些錯誤";
//				//warningContent = "處理有些錯誤";
//				OAuthErrorMessage errorMessage = e.getAuthErrorMessage();
//				if (errorMessage != null) {
//					//setErrorMessage("發生錯誤", errorMessage.getError_description());
//				}
//				return "developer/app/edit";
//			}
//			/**
//			 * with following message
//			 * <h4>修改/刪除 成功</h4>
//           		<p>您已成功修改/刪除 APP</p>
//			 */
//			return "common/message";
//		//}
//		// TODO 403 forbidden
//		//return "error";
	}

	@RequestMapping("/delete")
	public String delete() {
		return "common/message";
//		getAPPbyAPPId(id);
//		//if (isAccessible) {
//			Application app = this.appService.remove(id);
//			if (app == null) {
//				//warningTitle = "有些錯誤";
//				//warningContent = "處理有些錯誤";
//
//    			/**
//    			 * with following message
//                <h4>操作失敗</h4>
//                <p>操作失敗，請稍後在試</p>
//    			 */
//    			return "common/message";
//			}
//			/**
//			 * with following message
//			 * <h4>修改/刪除 成功</h4>
//           		<p>您已成功修改/刪除 APP</p>
//			 */
//			return "common/message";
//		//}
//		// TODO 403 forbidden
//		//return "error";
	}

	private IdApplication getAPPbyAPPId(String id) {
//		String userId = PersonUtil.getStudentId(request);
//		IdApplication appInfo = appService.getAPPbyAPPId(id);
//		if (appInfo == null) {
//			//setErrorMessage("找無此APP", "無法找到該APP，可以是因為已被刪除");
//		} else if (!appService.isAllowToAccess(appInfo, userId)) {
//			//setErrorMessage("您無權限存取該APP", "您無權限存取該APP，您並非是此APP的傭有者");
//		} else {
//			return appInfo;
//		}
		return null;
	}

	private IdApplication copyAPPInfo(IdApplication main, IdApplication old) {
		main.setId(old.getId());
		main.setOwner(old.getOwner());
		return main;
	}
	
	/**
	 * 在編輯頁面按下「更新secret」
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/secret")
	public String refreshSecret(Model model, @RequestParam(value = "id", required = true) String id) {
		
		String username = userContextService.getCurrentUsername();
		
		Optional<IdApplication> appInfo = this.appService.findById(id);
		
		if (!appInfo.isPresent()) {
			logger.warn("Potential hacker, trying to refresh non exist app secret.");
			return "error/404";
		}
		
		if (!appService.isAllowToAccess(appInfo.get(), username)) {
			logger.warn("Potential hacker, trying to refresh non-authorized app secret.");
			return "error/404";			
		}
		
		Optional<SecretIdApplication> newSecret = this.appService.refreshSecret(id);
		
		if (!newSecret.isPresent()) {
			
			logger.info("Can\'t refresh secret for app id {}", id);
			model.addAttribute("messageTitle", "無法更新")
			     .addAttribute("messageContent", "無法更新secret，請洽系統管理員。");
			
			return "common/message";
		}
		
		model.addAttribute("messageTitle", "更新成功")
	     	 .addAttribute("messageContent", "更新secret成功");
		return "common/message";
	}
}
