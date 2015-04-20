package tw.edu.ncu.cc.manage.dao.impl;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import tw.edu.ncu.cc.manage.dao.AbstractHibernateDao;
import tw.edu.ncu.cc.manage.dao.IPersonDao;
import tw.edu.ncu.cc.manage.entity.Person;

@Repository
public class PersonDao extends AbstractHibernateDao implements IPersonDao {

	@Override
	public Optional<Person> findByAccount(String account) {
		Person person = (Person) getSession().createQuery("from Person as p where p.account = :account and deleted=false")
		.setParameter("account", account.trim()).uniqueResult();
		return Optional.ofNullable(person);
	}

	@Override
	public Serializable create(Person person) {
		return getSession().save(person);
	}

}
