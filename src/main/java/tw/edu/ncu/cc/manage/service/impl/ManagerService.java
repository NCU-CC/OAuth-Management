package tw.edu.ncu.cc.manage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IManagerDao;
import tw.edu.ncu.cc.manage.domain.Manager;
import tw.edu.ncu.cc.manage.service.IManagerService;

@Service
public class ManagerService implements IManagerService {

	@Autowired
	private IManagerDao managerDao;
	
	@Override
	public List<Manager> findAll() {
		return this.managerDao.findAll();
	}

	@Override
	@Cacheable("manager")
	public Optional<Manager> find(String id) {
		return this.managerDao.find(id);
	}

	@Override
	@CachePut("manager")
	public Manager create(Manager manager) {
		return this.managerDao.create(manager);
	}

	@Override
	@CacheEvict("manager")
	public void delete(Manager manager) {
		this.managerDao.delete(manager);
	}
}