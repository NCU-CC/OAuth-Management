package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.edu.ncu.cc.manage.domain.Manager;
import tw.edu.ncu.cc.manage.service.IManagerService;

/**
 * 系統管理員管理
 * @author yyc1217
 *
 */
@Controller
@RequestMapping("/godmode/manager")
public class ManagerController {
	
	@Autowired
	private IManagerService managerService;
	
	/**
	 * 首頁
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		List<Manager> managerList = this.managerService.findAll();
		model.addAttribute("managerList", managerList);
		return "manager/index";
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "manager/create";
	}
	
	/**
	 * 在新增頁面按下「新增」
	 * @param manager
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSubmit(@ModelAttribute Manager manager) {
		//TODO use validator
		this.managerService.create(manager);
		return "redirect:../manager/index";
	}
	
	// 刪除
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id) {
		
		Manager manager = this.managerService.find(id).get();
		this.managerService.delete(manager);
		
		return "redirect:../manager/index";
	}
	
}
