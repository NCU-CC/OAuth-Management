package tw.edu.ncu.cc.manage.dao;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.Manager;

public interface IManagerDao {
	List<Manager> findAll();
	
	Optional<Manager> find(String id);
	
	Manager create(Manager manager);
	
	void remove(Manager manager);
}
