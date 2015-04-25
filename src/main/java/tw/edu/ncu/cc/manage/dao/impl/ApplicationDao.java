package tw.edu.ncu.cc.manage.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import tw.edu.ncu.cc.manage.dao.AbstractRestfulClientDao;
import tw.edu.ncu.cc.manage.dao.IApplicationDao;
import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.utils.SystemConstant;

@Repository
public class ApplicationDao extends AbstractRestfulClientDao<IdApplication> implements IApplicationDao {
	
	@Override
	public List<IdApplication> findAll(String username) throws IOException {
		return getList(SystemConstant.USER_SERVICE_URL + username + "/application");
	}

	@Override
	public Optional<IdApplication> findById(String applicationId) throws IOException {
		return Optional.ofNullable(get(SystemConstant.SERVICE_URL + applicationId));
	}

	@Override
	public Optional<IdApplication> update(IdApplication application) throws IOException, OAuthConnectionException {
		return Optional.ofNullable(put(SystemConstant.SERVICE_URL + application.getId(), application));
	}

	@Override
	public Optional<IdApplication> create(Application application) throws IOException, OAuthConnectionException {
		return Optional.ofNullable(post(SystemConstant.SERVICE_URL, application));
	}

	@Override
	public void remove(IdApplication application) throws IOException, OAuthConnectionException {
		delete(SystemConstant.SERVICE_URL + application.getId());
	}

	@Override
	public Optional<IdApplication> refreshSecret(String applicationId) throws IOException, OAuthConnectionException {
		return Optional.ofNullable(post(SystemConstant.SERVICE_URL + applicationId + "/secret/"));
	}
}
