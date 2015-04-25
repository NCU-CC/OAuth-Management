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

@Repository
public class ApplicationDao extends AbstractRestfulClientDao<IdApplication> implements IApplicationDao {
	
	public static final String USER_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";
	
	public static final String SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/application/";
	
	@Override
	public List<IdApplication> findAll(String username) throws IOException {
		return getList(USER_SERVICE_URL + username + "/application");
	}

	@Override
	public Optional<IdApplication> findById(String applicationId) throws IOException {
		return Optional.ofNullable(get(SERVICE_URL + applicationId));
	}

	@Override
	public Optional<IdApplication> update(IdApplication application) throws IOException, OAuthConnectionException {
		return Optional.ofNullable(put(SERVICE_URL + application.getId(), application));
	}

	@Override
	public Optional<IdApplication> create(Application application) throws IOException, OAuthConnectionException {
		return Optional.ofNullable(post(SERVICE_URL, application));
	}

	@Override
	public void remove(IdApplication application) throws IOException, OAuthConnectionException {
		delete(SERVICE_URL + application.getId());
	}

	@Override
	public Optional<IdApplication> refreshSecret(String applicationId) throws IOException, OAuthConnectionException {
		return Optional.ofNullable(post(SERVICE_URL + applicationId + "/secret/"));
	}
}
