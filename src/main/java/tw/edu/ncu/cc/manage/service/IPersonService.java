package tw.edu.ncu.cc.manage.service;

import java.io.IOException;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.Person;

public interface IPersonService {
	public static final String OAUTH_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";

	/**
	 * 以account來獲得使用者資訊
	 * @param account
	 * @return
	 */
	Optional<Person> findByAccount(String account);
	
	/**
	 * 在OAuth-Service新增使用者
	 * @param account
	 * @throws IOException
	 */
	void createUserOnOAuthService(String account) throws IOException;
	
	/**
	 * 更新使用者狀態
	 * @param person
	 * @param ip
	 */
	void refresh(Person person, String ip);

	/**
	 * 新增使用者
	 * @param person
	 */
	void create(Person person);
}
