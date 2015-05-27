package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IApplicationDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.entity.oauth.Application;

@Repository
public class ApplicationDao extends AbstractOAuthServiceDao<Application> implements IApplicationDao {
	
	@Override
	public List<Application> findAll(String username) {
		
		Assert.hasText(username);
		return getList(userUrl + username + "/clients");
	}

	@Override
	public Optional<Application> findById(String applicationId){
		Assert.hasText(applicationId);
		return Optional.ofNullable(get(clientUrl + applicationId));
	}

	@Override
	public Optional<Application> update(Application application){
		Assert.notNull(application);
		return Optional.ofNullable(put(clientUrl + application.getId(), application));
	}

	@Override
	public Optional<Application> create(Application application){
		Assert.notNull(application);
		return Optional.ofNullable(post(clientUrl, application));
	}

	@Override
	public void remove(Application application) {
		Assert.notNull(application);
		delete(clientUrl + application.getId());
	}

	@Override
	public Optional<Application> refreshSecret(String applicationId) {
		Assert.hasText(applicationId);
		return Optional.ofNullable(post(clientUrl + applicationId + "/secret/", null));
	}
}
