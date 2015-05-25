package tw.edu.ncu.cc.manage.service;

import java.io.IOException;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IPersonService {


	/**
	 * 以account來獲得使用者資訊
	 * @param account
	 * @return
	 */
	Optional<Person> findByAccount(String account);
	
	/**
	 * 在OAuth-Service新增使用者
	 * @param account
	 * @return 
	 * @throws IOException
	 * @throws OAuthConnectionException 
	 */
	Person createUserOnOAuthService(String account) throws IOException, OAuthConnectionException;
	
	/**
	 * 更新使用者狀態
	 * @param person
	 * @param ip
	 */
	void refreshLastIp(Person person, String ip);

	/**
	 * 新增使用者
	 * @param person
	 */
	void create(Person person);
}
