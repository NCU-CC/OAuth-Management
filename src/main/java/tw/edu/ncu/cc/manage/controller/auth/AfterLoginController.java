package tw.edu.ncu.cc.manage.controller.auth;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.login.IPersonService;
import tw.edu.ncu.cc.manage.util.PersonInfo;

@Controller
public class AfterLoginController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private IPersonService<Person> service;

	@RequestMapping("/logined")
	public String logined(@RequestParam(value = "tmpId") String personId, HttpSession session, HttpServletRequest request) {
		Optional<Person> person = this.service.findPersonByAccount(personId);
		
		if (person.isPresent()) {
			this.service.refreshActivateInfo(person.get(), request.getRemoteAddr());
		} else {
			this.service.createUserOnRemoteServer(personId);
			Person newPerson = this.service.getNewLoginPerson(request, personId);
			this.service.create(newPerson);
		}

		session.setAttribute(PersonInfo.PERSON_INFO, person.get());
		return "redirect:/";
	}
}