package tw.edu.ncu.cc.manage.dao;

import java.io.Serializable;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.Person;

public interface IPersonDao {

	Optional<Person> findByAccount(String account);

	Serializable create(Person person);

}
