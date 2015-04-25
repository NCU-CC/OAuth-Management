package tw.edu.ncu.cc.manage.dao;

import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IPersonDao {

	Optional<Person> findByAccount(String account);

	Serializable create(Person person);

	Person createUserOnOAuthService(String username) throws IOException, OAuthConnectionException;
}
