package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tw.edu.ncu.cc.manage.domain.BlacklistUser;
import tw.edu.ncu.cc.manage.service.IBlacklistUserService;

/**
 * 使用者黑名單管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/godmode/blacklist/user")
public class UserBlackListController {

	@Autowired
	private IBlacklistUserService blacklistUserService;
	
	/**
	 * 使用者黑名單首頁
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "blacklist/user/list";
	}
	
	/**
	 * 搜尋使用者黑名單
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "action=search")
	public ModelAndView search(Model model, @ModelAttribute BlacklistUser dto) {
		
		List<BlacklistUser> userList = this.blacklistUserService.search(dto);
		
		return new ModelAndView("blacklist/user/list", "userList", userList);
	}
	
	/**
	 * 新增使用者黑名單頁面
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("blacklist/user/create", "user", new BlacklistUser());
	}
	
	/**
	 * 在新增使用者黑名單頁面按下送出
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSubmit(@ModelAttribute BlacklistUser user) {
		
		this.blacklistUserService.create(user);
		
		return "redirect:../user?action=search&username=" + user.getUsername();
	}
	
	/**
	 * 編輯黑名單頁面
	 * @return
	 */
	@RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable String username) {
		
		BlacklistUser user = this.blacklistUserService.find(username).get();
		
		return new ModelAndView("blacklist/user/edit", "user", user);
	}
	
	/**
	 * 在編輯黑名單頁面按下送出
	 * @return
	 */
	@RequestMapping(value = "/edit/{username}", method = RequestMethod.POST)
	public String editSubmit(@ModelAttribute BlacklistUser user) {
		
		this.blacklistUserService.remove(user);
		
		return "redirect:../../user?action=search&username=" + user.getUsername();
	}
	
	/**
	 * 在搜尋後，按下「刪除」
	 * @return
	 */
	@RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
	public String delete(@PathVariable String username) {

		BlacklistUser blacklistUser = this.blacklistUserService.search(new BlacklistUser(username)).stream().findAny().get();
		this.blacklistUserService.remove(blacklistUser);
		
		return "redirect:..";
	}
	
}
