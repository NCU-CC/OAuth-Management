package tw.edu.ncu.cc.manage.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IApplicationDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractRestfulClientDao;
import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.utils.SystemConstant;

@Repository
public class ApplicationDao extends AbstractRestfulClientDao<IdApplication> implements IApplicationDao {
	
	@Override
	public List<IdApplication> findAll(String username) throws IOException {
		Assert.hasText(username);
		return getList(SystemConstant.OAUTH_USER_SERVICE_URL + username + "/clients");
	}

	@Override
	public Optional<IdApplication> findById(String applicationId) throws IOException {
		Assert.hasText(applicationId);
		return Optional.ofNullable(get(SystemConstant.OAUTH_APPLICATION_SERVICE_URL + applicationId));
	}

	@Override
	public Optional<IdApplication> update(IdApplication application) throws IOException, OAuthConnectionException {
		Assert.notNull(application);
		return Optional.ofNullable(put(SystemConstant.OAUTH_APPLICATION_SERVICE_URL + application.getId(), application));
	}

	@Override
	public Optional<IdApplication> create(Application application) throws IOException, OAuthConnectionException {
		Assert.notNull(application);
		return Optional.ofNullable(post(SystemConstant.OAUTH_APPLICATION_SERVICE_URL, application));
	}

	@Override
	public void remove(IdApplication application) throws IOException, OAuthConnectionException {
		Assert.notNull(application);
		delete(SystemConstant.OAUTH_APPLICATION_SERVICE_URL + application.getId());
	}

	@Override
	public Optional<IdApplication> refreshSecret(String applicationId) throws IOException, OAuthConnectionException {
		Assert.hasText(applicationId);
		return Optional.ofNullable(post(SystemConstant.OAUTH_APPLICATION_SERVICE_URL + applicationId + "/secret/"));
	}
}
