package tw.edu.ncu.cc.manage.service.login;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.entity.oauth.User;
import tw.edu.ncu.cc.manage.service.IService;

public interface IPersonService extends IService<Person> {
	public static final String OAUTH_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";

	Optional<Person> findByAccount(String account);
	
	void createUserOnRemoteServer(String id) throws IOException;
	
	void refresh(Person person, String ip);
}
