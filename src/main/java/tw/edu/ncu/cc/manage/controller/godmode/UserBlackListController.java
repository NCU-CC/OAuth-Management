package tw.edu.ncu.cc.manage.controller.godmode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.edu.ncu.cc.manage.domain.User;
import tw.edu.ncu.cc.manage.service.IUserService;

/**
 * 使用者黑名單管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/godmode/blacklist/user")
public class UserBlackListController {

	/**
	 * 黑名單首頁
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "blacklist/user/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "action=search")
	public String search(Model model, @ModelAttribute User dto) {
		return "blacklist/user/list";
	}
	
	// 新增黑名單
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "blacklist/user/create";
	}
	
	// 編輯黑名單
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "blacklist/user/edit";
	}
	
	// 刪除黑名單
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "blacklist/user/list";
	}
	
}
