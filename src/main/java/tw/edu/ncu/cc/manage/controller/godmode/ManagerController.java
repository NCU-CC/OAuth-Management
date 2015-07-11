package tw.edu.ncu.cc.manage.controller.godmode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView index() {
		List<Manager> managerList = this.managerService.findAll();
		return new ModelAndView("manager/index", "managerList", managerList);
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("manager/create", "manager", new Manager());
	}
	
	/**
	 * 在新增頁面按下「新增」
	 * @param manager
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSubmit(Model model, @ModelAttribute Manager manager, BindingResult result) {
		
		//TODO validator
		if (result.hasErrors()) {
			model.addAttribute("manager", manager);
			return "manager/create";
		}
		
		this.managerService.create(manager);
		return "redirect:../manager";
	}
	
	// 刪除
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id) {
		
		Manager manager = this.managerService.find(id).get();
		this.managerService.delete(manager);
		
		return "redirect:../";
	}
	
}
