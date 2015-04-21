package tw.edu.ncu.cc.manage.controller.developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.IApplicationContextService;
import tw.edu.ncu.cc.manage.service.IApplicationService;

@Controller
@RequestMapping("/developer/app")
public class DeveloperAppListController {
	
	@Autowired
	private IApplicationService applicationService;

	@Autowired
	private IApplicationContextService applicationContextService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		String userId = this.applicationContextService.getCurrentUser().getAccount();
		List<IdApplication> applicationList = this.applicationService.findAll(userId);
		
		model.addAttribute("appList", applicationList);
		
		return "developer/app/list";
	}
}
