package tw.edu.ncu.cc.manage.controller.oauth.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.oauth.IAPPService;
import tw.edu.ncu.cc.manage.util.PersonUtil;

@Controller
@RequestMapping("/dev")
public class APPListController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IAPPService service;

	@RequestMapping("/list")
	public String list(HttpServletRequest request) throws Exception {
		String userId = PersonUtil.getStudentId(request);
		List<IdApplication>  appList = service.getAllAPPsByUserId(userId);
		return "applist";
	}

}
