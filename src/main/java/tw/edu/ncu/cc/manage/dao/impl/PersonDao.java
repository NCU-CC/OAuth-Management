package tw.edu.ncu.cc.manage.dao.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IPersonDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractHibernateDao;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.utils.RestfulClientUtils;
import tw.edu.ncu.cc.manage.utils.SystemConstant;

@Repository
public class PersonDao extends AbstractHibernateDao<Person> implements IPersonDao {
	
	@Override
	public Optional<Person> findByAccount(String account) {
		Assert.hasText(account);
		Person person = (Person) getSession().createQuery("from Person as p where p.account = :account and deleted=false")
		.setParameter("account", account.trim()).uniqueResult();
		return Optional.ofNullable(person);
	}

	@Override
	public Person createUserOnOAuthService(String username) throws IOException, OAuthConnectionException {
		Assert.hasText(username);
		String response = RestfulClientUtils.post(SystemConstant.OAUTH_USER_SERVICE_URL, new User(username));
		return RestfulClientUtils.convert(response, Person.class);
	}
	
	static class User {
		private String name;

		User(String name) {
			this.setName(name);
		}

		String getName() {
			return name;
		}

		void setName(String name) {
			this.name = name;
		}
	}
}
