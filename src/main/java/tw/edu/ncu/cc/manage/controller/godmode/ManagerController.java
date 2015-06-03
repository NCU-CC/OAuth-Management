package tw.edu.ncu.cc.manage.controller.godmode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系統管理員管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/godmode/manager")
public class ManagerController {
	
	// 首頁
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "manager/index";
	}
	
	// 新增
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "manager/create";
	}
	
	// 刪除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "manager/index";
	}
	
}
