package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.Manager;

public interface IManagerService {
	List<Manager> findAll();
	
	Optional<Manager> find(String id);
	
	Manager create(Manager manager);
	
	void remove(Manager manager);
}
