package tw.edu.ncu.cc.manage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.service.IUserContextService;
import tw.edu.ncu.cc.manage.utils.SystemConstant;

/**
 * 首頁
 * @author yyc1217
 *
 */
@Controller
public class IndexController {

	@Autowired
	private IUserContextService applicationContextService;
	
    @RequestMapping({"/", "/index", "/default"})
    public String index(HttpSession session) {
    	session.setAttribute(SystemConstant.USER_KEY, this.applicationContextService.getCurrentUser());
        return "index";
    }
}
