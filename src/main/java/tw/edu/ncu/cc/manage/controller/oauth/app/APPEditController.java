package tw.edu.ncu.cc.manage.controller.oauth.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.entity.oauth.OAuthErrorMessage;
import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.oauth.IAPPService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.util.PersonUtil;

@Controller
@RequestMapping("/dev")
public class APPEditController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAPPService appService;
	private String id;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping("/edit")
	public String Edit() {
		IdApplication appInfo = getAPPbyAPPId(id);
//		if (isAccessible) {
//			//createTokenForGet();
//			return "appedit";
//		}
		// TODO 403 exception
		//return "error";
		return "appedit";
	}

	@RequestMapping("/edited")
	public String upload() {
		IdApplication old = getAPPbyAPPId(id);
		//if (isAccessible) {
			//IdApplication appInfo = copyAPPInfo(appInfo, old);
			IdApplication appInfo = new IdApplication();
			try {
				Application app = this.appService.updateAPP(appInfo);
				if (app == null) {
					warningTitle = "有些錯誤";
					warningContent = "處理有些錯誤";
					return "appedit";
				}
			} catch (OAuthConnectionException e) {
				warningTitle = "有些錯誤";
				warningContent = "處理有些錯誤";
				OAuthErrorMessage errorMessage = e.getAuthErrorMessage();
				if (errorMessage != null) {
					//setErrorMessage("發生錯誤", errorMessage.getError_description());
				}
				return "appedit";
			}
			return "appeditsuc";
		//}
		// TODO 403 forbidden
		//return "error";
	}

	@RequestMapping("/delete")
	public String delete() {
		getAPPbyAPPId(id);
		//if (isAccessible) {
			Application app = this.appService.removeAPP(id);
			if (app == null) {
				warningTitle = "有些錯誤";
				warningContent = "處理有些錯誤";
				return "appeditdeletefail";
			}
			return "appeditsuc";
		//}
		// TODO 403 forbidden
		//return "error";
	}

	private IdApplication getAPPbyAPPId(String id) {
		String userId = PersonUtil.getStudentId(request);
		IdApplication appInfo = appService.getAPPbyAPPId(id);
		if (appInfo == null) {
			//setErrorMessage("找無此APP", "無法找到該APP，可以是因為已被刪除");
		} else if (!appService.isAllowToAccess(appInfo, userId)) {
			//setErrorMessage("您無權限存取該APP", "您無權限存取該APP，您並非是此APP的傭有者");
		} else {
			return appInfo;
		}
		return null;
	}

	private IdApplication copyAPPInfo(IdApplication main, IdApplication old) {
		main.setId(old.getId());
		main.setOwner(old.getOwner());
		return main;
	}
}
