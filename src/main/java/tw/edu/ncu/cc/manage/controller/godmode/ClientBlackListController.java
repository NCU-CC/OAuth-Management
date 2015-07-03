package tw.edu.ncu.cc.manage.controller.godmode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 應用服務黑名單管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/godmode/blacklist/client")
public class ClientBlackListController {

	// 黑名單首頁
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "blacklist/client/list";
	}
	
	// 新增黑名單
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "blacklist/client/create";
	}
	
	// 編輯黑名單
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "blacklist/client/edit";
	}
	
	// 刪除黑名單
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "blacklist/client/list";
	}
	
}
