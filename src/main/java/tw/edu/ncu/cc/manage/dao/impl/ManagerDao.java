package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IManagerDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.Manager;
@Repository
public class ManagerDao extends AbstractOAuthServiceDao<Manager> implements IManagerDao {
	
	private static final ParameterizedTypeReference<List<Manager>> parameterizedTypeReference = new ParameterizedTypeReference<List<Manager>>() {};
	
	@Override
	protected ParameterizedTypeReference<List<Manager>> parameterizedTypeReferenceForList() {
		return parameterizedTypeReference;
	}	
	
	@Override
	public List<Manager> findAll() {
		return getList(managerUrl());
	}

	@Override
	@Cacheable("managers")
	public Optional<Manager> find(String id) {

		if (StringUtils.isEmpty(id)) {
			return Optional.empty();
		}

		return get(withUrl(managerUrl(), id));
	}

	@Override
	@CachePut("managers")
	public Manager create(Manager manager) {
		Assert.notNull(manager);
		return post(managerUrl(), manager);
	}

	@Override
	@CacheEvict("managers")
	public void remove(Manager manager) {
		Assert.notNull(manager);
		delete(withUrl(managerUrl(), manager.getId()));
	}
}
