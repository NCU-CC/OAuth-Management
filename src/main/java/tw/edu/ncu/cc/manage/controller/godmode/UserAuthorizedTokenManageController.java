package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	 * @param dto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "action=search")
	public ModelAndView search(@ModelAttribute User dto) {
		
		List<User> userList = this.userService.search(dto);
		
		return new ModelAndView("userAuthorizedTokenManage/list", "userList", userList);
	}
}
