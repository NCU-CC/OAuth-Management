package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.edu.ncu.cc.manage.domain.User;
import tw.edu.ncu.cc.manage.service.IUserService;

/**
 * 使用者管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/godmode/userAuthorizedTokenManage")
public class UserAuthorizedTokenManageController {

	@Autowired
	private IUserService userService;
	
	/**
	 * 使用者管理首頁
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "userAuthorizedTokenManage/list";
	}
	
	/**
	 * 在使用者管理首頁按下「搜尋」
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "action=search")
	public String search(Model model, @ModelAttribute User dto) {
		
		List<User> userList = this.userService.search(dto);
		
		model.addAttribute("userList", userList);
		
		return "userAuthorizedTokenManage/list";
	}
}
