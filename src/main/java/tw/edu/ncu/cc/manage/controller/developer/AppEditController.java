package tw.edu.ncu.cc.manage.controller.developer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.IApplicationService;

@Controller
@RequestMapping("/developer/app")
public class AppEditController {

	@Autowired
	private IApplicationService appService;
	private String id;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping("/edit")
	public String edit() {
		return "developer/app/edit";
//		IdApplication appInfo = getAPPbyAPPId(id);
//		if (isAccessible) {
//			//createTokenForGet();
//			return "appedit";
//		}
		// TODO 403 exception
		//return "error";
//		return "developer/app/edit";
	}

	@RequestMapping("/edited")
	public String upload() {
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
}
