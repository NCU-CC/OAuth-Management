package tw.edu.ncu.cc.manage.controller.login;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.login.IPersonService;
import tw.edu.ncu.cc.manage.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class AfterLoginController extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private HttpServletRequest request;
	private IPersonService<Person> service;

	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		String tmpId = PersonUtil.getTmpId(session);
		if (StringUtils.isNotEmpty(tmpId)) {
			session = getNewSession(session);
			Person person = updatePersonInfo(tmpId);
			addInSession(person);
			return SUCCESS;
		}
		return ERROR;
	}

	private HttpSession getNewSession(HttpSession session) {
		session.invalidate();
		return request.getSession(true);
	}

	private Person updatePersonInfo(String personId) {
		Person person = service.findPersonByAccount(personId);
		if (person != null) {
			notNewLogin(person);
			service.save(person);
		} else {
			service.createUserOnRemoteServer(personId);
			person = service.getNewLoginPerson(request, personId);
			service.create(person);
		}
		return person;
	}

	private void addInSession(Person person) {
		PersonUtil.setPersonInf(request, person);
	}

	private void notNewLogin(Person person) {
		person.setDateLastActived(new Date());
		person.setIpLastActived(request.getRemoteAddr());
	}

	@Inject
	public void setService(IPersonService<Person> service) {
		this.service = service;
	}

}