package tw.edu.ncu.cc.manage.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.edu.ncu.cc.manage.utils.SystemConstant;

/**
 * 首頁
 * @author yyc1217
 *
 */
@Controller
@SessionAttributes(SystemConstant.USER_KEY)
public class IndexController {

    @RequestMapping({"/", "/index", "/default"})
    public String index(Model model) {
    	if (!model.containsAttribute(SystemConstant.USER_KEY)) {
    		model.addAttribute(SystemConstant.USER_KEY, SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    	}
        return "index";
    }
}
