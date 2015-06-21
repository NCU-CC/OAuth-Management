package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IManagerDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.Manager;
@Repository
public class ManagerDao extends AbstractOAuthServiceDao<Manager> implements IManagerDao {

	@Override
	@Cacheable("managers")
	public List<Manager> findAll() {
		return getList(managerUrl);
	}

	@Override
	public Optional<Manager> find(String id) {
		Assert.hasText(id);
		return get(withUrl(managerUrl, id));
	}

	@Override
	@CachePut("managers")
	public Manager create(Manager manager) {
		Assert.notNull(manager);
		return post(withUrl(managerUrl, manager.getId()));
	}

	@Override
	@CacheEvict("managers")
	public void delete(Manager manager) {
		Assert.notNull(manager);
		delete(withUrl(managerUrl, manager.getId()));
	}

}
