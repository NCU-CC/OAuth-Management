package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tw.edu.ncu.cc.manage.domain.User;
import tw.edu.ncu.cc.manage.service.IUserService;

@Controller
@RequestMapping("/godemode/userManage")
public class UserManageController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "userManage/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "action=search")
	public ModelAndView search(@ModelAttribute User dto) {
		
		List<User> userList = this.userService.search(dto);
		
		return new ModelAndView("userManage/list", "userList", userList);
	}
}
