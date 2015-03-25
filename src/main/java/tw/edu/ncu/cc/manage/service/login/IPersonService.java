package tw.edu.ncu.cc.manage.service.login;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.entity.oauth.User;
import tw.edu.ncu.cc.manage.service.IService;

public interface IPersonService<T extends Person> extends IService<T> {
	public static final String SERVICEURL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";

	Optional<T> findPersonByAccount(String account);

	Person getNewLoginPerson(HttpServletRequest request, String id);

	User createUserOnRemoteServer(String id);
	
	void refreshActivateInfo(T person, String ip);
}
