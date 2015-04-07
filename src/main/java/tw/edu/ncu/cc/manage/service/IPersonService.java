package tw.edu.ncu.cc.manage.service;

import java.io.IOException;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.Person;

public interface IPersonService {
	public static final String OAUTH_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";

	Optional<Person> findByAccount(String account);
	
	void createUserOnRemoteServer(String id) throws IOException;
	
	void refresh(Person person, String ip);

	void create(Person person);
}
