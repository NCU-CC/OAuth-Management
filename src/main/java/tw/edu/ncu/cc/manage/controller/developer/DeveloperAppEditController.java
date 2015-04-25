package tw.edu.ncu.cc.manage.controller.developer;

import java.io.IOException;
import java.net.MalformedURLException;
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
import tw.edu.ncu.cc.manage.service.IApplicationService;
import tw.edu.ncu.cc.manage.service.IUserContextService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

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
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(Model model, @RequestParam(value = "id", required = true) String id) throws MalformedURLException, IOException {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<IdApplication> application = this.appService.findById(id);
		if (!isAuthorized(application, username)) {
			return "error/404";
		}
		
		model.addAttribute("application", application);
		
		return "developer/app/edit";
	}

	/**
	 * 按下「更新App」
	 * @param model
	 * @param editedApplication
	 * @return
	 * @throws OAuthConnectionException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(Model model, @ModelAttribute IdApplication editedApplication) throws OAuthConnectionException, MalformedURLException, IOException {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<IdApplication> oldApplication = this.appService.findById(editedApplication.getId());
		if (!isAuthorized(oldApplication, username)) {
			return "error/404";
		}

		copySubmitValue(editedApplication, oldApplication.get());
		
		this.appService.update(editedApplication);
		
		model.addAttribute("messageTitle", "修改成功")
		     .addAttribute("messageContent", "app修改成功");
		
		return "common/message";
	}
	
	private void copySubmitValue(IdApplication from, IdApplication to) {
		to.setId(from.getId());
		to.setOwner(from.getOwner());
	}
	
	/**
	 * 按下「刪除App」
	 * @param model
	 * @param id
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws OAuthConnectionException 
	 */
	@RequestMapping("/delete")
	public String delete(Model model, @RequestParam(value = "id", required = true) String id) throws MalformedURLException, IOException, OAuthConnectionException {
		
		String username = this.userContextService.getCurrentUsername();
		Optional<IdApplication> application = this.appService.findById(id);
		if (!isAuthorized(application, username)) {
			return "error/404";
		}
		
		this.appService.remove(application.get());

		model.addAttribute("messageTitle", "刪除成功")
	         .addAttribute("messageContent", "app刪除成功");
		
		return "common/message";
	}
	
	/**
	 * 在編輯頁面按下「更新secret」
	 * @param model
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws OAuthConnectionException 
	 */
	@RequestMapping("/secret")
	public String refreshSecret(Model model, @RequestParam(value = "id", required = true) String id) throws MalformedURLException, IOException, OAuthConnectionException {
		
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
		
		this.appService.refreshSecret(id);
		
		model.addAttribute("messageTitle", "更新成功")
	     	 .addAttribute("messageContent", "更新secret成功");
		
		return "common/message";
	}
	
	/**
	 * 是有權限處理的{@link IdApplication}
	 * @param application
	 * @param username
	 * @return
	 */
	private boolean isAuthorized(Optional<IdApplication> application, String username) {
		if (!application.isPresent()) {
			logger.warn("Potential hacker, trying to edit non exist app.");
			return false;
		}
		
		if (!this.appService.isAllowToAccess(application.get(), username)) {
			logger.warn("Potential hacker, trying to edit non-authorized app.");
			return false;
		}
		return true;
	}
}
