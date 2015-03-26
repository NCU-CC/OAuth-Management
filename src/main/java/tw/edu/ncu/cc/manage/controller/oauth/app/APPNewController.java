package tw.edu.ncu.cc.manage.controller.oauth.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.controller.BasicController;
import tw.edu.ncu.cc.manage.entity.oauth.OAuthErrorMessage;
import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.oauth.IAPPService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.util.PersonUtil;

@Controller
@RequestMapping("/dev")
public class APPNewController extends BasicController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAPPService appService;

	@RequestMapping("/new")
	public String index() {
		return "appregister";
	}

	@RequestMapping("/tonew")
	public String create(HttpServletRequest request) {
		Application appInfo = new Application();
		appInfo.setOwner(PersonUtil.getStudentId(request));
		try {
			SecretIdApplication appInfoid = this.appService.create(appInfo);
			if (appInfoid != null) {
				return "appregistersuc";
			}
			setDefaultError();
		} catch (OAuthConnectionException e) {
			OAuthErrorMessage errorMessage = e.getAuthErrorMessage();
			if (errorMessage != null) {
				setErrorMessage("發生錯誤", errorMessage.getError_description());
			}
		}
		return "appregister";
	}

	@RequestMapping("/secret")
	public String update(@RequestParam String id, HttpServletRequest request) {
		String userId = PersonUtil.getStudentId(request);
		IdApplication appInfo = appService.getAPPbyAPPId(id);
		if (appInfo == null) {
			setErrorMessage("找無此APP", "無法找到該APP，可以是因為已被刪除");
		} else if (!appService.isAllowToAccess(appInfo, userId)) {
			setErrorMessage("您無權限存取該APP", "您無權限存取該APP，您並非是此APP的傭有者");
		}

		if (appInfo != null) {
			SecretIdApplication appInfoid = appService.newSecret(id);
			if (appInfoid == null) {
				return "appeditdeletefail";
			}
			return "appregistersuc";
		}
		return "appeditdeletefail";
	}

	private void setDefaultError() {
		setErrorMessage("未知原因", "請稍後在試");
	}
}
