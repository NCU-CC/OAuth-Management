package tw.edu.ncu.cc.manage.controller.developer;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.inject.internal.Lists;

import tw.edu.ncu.cc.manage.entity.oauth.Application;
import tw.edu.ncu.cc.manage.service.IUserContextService;
import tw.edu.ncu.cc.manage.service.IApplicationService;

/**
 * 開發者的app清單
 * @author yyc1217
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
		
		/* TODO
		String username = this.userContextService.getCurrentUsername();
		List<Application> applicationList = this.applicationService.findAll(username);
		*/
		 
		List<Application> applicationList = mockApps();
		
		model.addAttribute("appList", applicationList);
		
		return "developer/app/list";
	}
	
	private List<Application> mockApps() {
		
		Application app1 = new Application();
		app1.setId("AABBCCDDEEDD1");
		app1.setDescription("應用服務描述1");
		app1.setCallback("https://www.example.com/auth/callback1");
		app1.setName("應用服務1");
		app1.setOwner("H367245-1");
		app1.setUrl("https://www.example.com1");
		
		Application app2 = new Application();
		app2.setId("AABBCCDDEEDD2");
		app2.setDescription("應用服務描述2");
		app2.setCallback("https://www.example.com/auth/callback2");
		app2.setName("應用服務2");
		app2.setOwner("H367245-2");
		app2.setUrl("https://www.example.com2");
		
		return Lists.newArrayList(app1, app2);
	}
}
