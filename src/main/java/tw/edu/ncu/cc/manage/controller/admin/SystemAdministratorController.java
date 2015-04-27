package tw.edu.ncu.cc.manage.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系統管理員管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/manager")
public class SystemAdministratorController {
	
	// 首頁
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "manager/list";
	}
	
	// 新增
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "manager/create";
	}
	
}
