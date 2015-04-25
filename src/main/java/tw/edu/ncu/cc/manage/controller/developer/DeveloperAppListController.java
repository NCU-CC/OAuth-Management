package tw.edu.ncu.cc.manage.controller.developer;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.IUserContextService;
import tw.edu.ncu.cc.manage.service.IApplicationService;

/**
 * 開發者的app清單
 * @author Yeh-Yung
 *
 */
@Controller
@RequestMapping("/developer/app")
public class DeveloperAppListController {
	
	@Autowired
	private IApplicationService applicationService;

	@Autowired
	private IUserContextService userContextService;
	
	/**
	 * 開發者app清單首頁
	 * @param model
	 * @return
	 * @throws IOException Remote OAuth service down.
	 */
	@RequestMapping("/list")
	public String list(Model model) throws IOException {
		
		String username = this.userContextService.getCurrentUsername();
		List<IdApplication> applicationList = this.applicationService.findAll(username);
		
		model.addAttribute("appList", applicationList);
		
		return "developer/app/list";
	}
}
