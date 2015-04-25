package tw.edu.ncu.cc.manage.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IApplicationDao;
import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.IApplicationService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ApplicationService implements IApplicationService {

	@Autowired
	private IApplicationDao applicationDao;

	@Override
	public boolean isAllowToAccess(Application app, String username) {
		return app.getOwner().equals(username);
	}

	@Override
	public List<IdApplication> findAll(String username) throws IOException {
		return this.applicationDao.findAll(username);
	}

	@Override
	public Optional<IdApplication> findById(String applicationId) throws MalformedURLException, IOException {
		return this.applicationDao.findById(applicationId);
	}

	@Override
	public Optional<IdApplication> update(IdApplication application) throws OAuthConnectionException, IOException {
		return this.applicationDao.update(application);
	}

	public Optional<IdApplication> create(Application application) throws OAuthConnectionException, JsonParseException, JsonMappingException,
			MalformedURLException, IOException {
		return this.applicationDao.create(application);
	}

	public void remove(IdApplication application) throws IOException, OAuthConnectionException {
		this.applicationDao.remove(application);
	}

	@Override
	public Optional<SecretIdApplication> refreshSecret(String applicationId) throws MalformedURLException, IOException, OAuthConnectionException {
		Optional<IdApplication> application = this.applicationDao.refreshSecret(applicationId);
		return Optional.ofNullable((SecretIdApplication) application.get());
	}
}
