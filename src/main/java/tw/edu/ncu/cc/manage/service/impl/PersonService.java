package tw.edu.ncu.cc.manage.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.dao.IPersonDao;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.IPersonService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

@Service
public class PersonService implements IPersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private IPersonDao personDao;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Optional<Person> findByAccount(String account) {
		return this.personDao.findByAccount(account);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void create(Person person) {
		if (!findByAccount(person.getAccount()).isPresent()) {
			throw new RuntimeException("Account " + person.getAccount() + "has already existed");
		}
		this.personDao.create(person);
	}

	@Override
	public void refresh(Person person, String ip) {
		person.setDateLastActived(new Date());
		person.setIpLastActived(ip);
	}

	@Override
	public Person createUserOnOAuthService(String username) throws IOException, OAuthConnectionException {
    	logger.debug("Create user on OAuth-Service: " + username);
    	return personDao.createUserOnOAuthService(username);
	}
}
