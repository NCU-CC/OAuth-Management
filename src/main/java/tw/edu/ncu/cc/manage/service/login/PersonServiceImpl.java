package tw.edu.ncu.cc.manage.service.login;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.AbstractService;
import tw.edu.ncu.cc.manage.service.oauth.connector.Connection;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PersonServiceImpl extends AbstractService<Person> implements IPersonService {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);
	
	public Connection connection;

	public PersonServiceImpl() {
		connection = new Connection();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Optional<Person> findByAccount(String account) {

		Person person = (Person) this.dao.createQuery("from Person as p where p.account = :account and deleted=false").setParameter("account", account.trim())
				.getSingleResult();

		return Optional.ofNullable(person);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void create(Person person) {
		if (findByAccount(person.getAccount()) != null) {
			throw new RuntimeException("Account " + person.getAccount() + "has already existed");
		}
		this.dao.create(person);
	}

	@Override
	public void refresh(Person person, String ip) {
		person.setDateLastActived(new Date());
		person.setIpLastActived(ip);
	}

	private static class User {
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

	@Override
	public void createUserOnRemoteServer(String id) throws IOException {

    	logger.debug("Create user on remote server: " + id + ", " + OAUTH_SERVICE_URL);
		
		HttpURLConnection connectionURL = connection.doConnection(
				new URL(OAUTH_SERVICE_URL), 
				MAPPER.writeValueAsString(new User(id)), 
				Connection.POST);
		
		int status = connectionURL.getResponseCode();
		connectionURL.connect();
		if (status == 200) {
			String userJsonString = connection.getStringFromConnection(connectionURL);
			logger.debug("Successful created: " + userJsonString);
			//user = MAPPER.readValue(userJsonString, User.class);
		} else {
			throw new RemoteServiceUnavailableException(OAUTH_SERVICE_URL);
		}
	}
	
	private static class RemoteServiceUnavailableException extends IOException {

		private static final long serialVersionUID = 1L;

		RemoteServiceUnavailableException(String message) {
			super(message);
		}
	}
}
