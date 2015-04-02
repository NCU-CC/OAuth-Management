package tw.edu.ncu.cc.manage.service.login;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.entity.PersonType;
import tw.edu.ncu.cc.manage.entity.oauth.User;
import tw.edu.ncu.cc.manage.service.ServiceImpl;
import tw.edu.ncu.cc.manage.service.oauth.connector.Connection;
import tw.edu.ncu.cc.manage.service.oauth.converter.UserConverter;

@Service
public class PersonServiceImpl extends ServiceImpl<Person> implements IPersonService {
	public Connection connection;

	public PersonServiceImpl() {
		connection = new Connection();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Optional<Person> findByAccount(String account) {
		Person person = (Person) this.getDao().creatQuery("select p from Person p " + "where p.account = :account and deleted=false ").setParameter("account", account.trim())
				.getSingleResult();
		
		return Optional.ofNullable(person);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void create(Person person) {
		if (findByAccount(person.getAccount()) != null) {
			throw new RuntimeException("account " + person.getAccount() + "has already existed");
		}
		this.getDao().create(person);
	}

	public Person getNewLoginPerson(HttpServletRequest request, String id) {
		Person person = new Person();
		person.setAccount(id);
		person.setDateCreated(null);

		person.setDateLastActived(null);
		person.setDeleted(false);
		person.setIpCreated(request.getRemoteAddr());
		person.setIpLastActived(request.getRemoteAddr());
		person.setType(PersonType.STUDENT.toString());
		return person;
	}

	public User createUserOnRemoteServer(String id) {
		User user = null;
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICEURL), UserConverter.convert(new User(id)), Connection.POST);
			int status = connectionURL.getResponseCode();
			connectionURL.connect();
			if (status == 200) {
				user = UserConverter.convert(connection.getStringFromConnection(connectionURL));
			}
		} catch (IOException e) {
			user = null;
		}
		return user;
	}

	@Override
	public void refreshActivateInfo(Person person, String ip) {
		person.setDateLastActived(new Date());
		person.setIpLastActived(ip);
	}

}
