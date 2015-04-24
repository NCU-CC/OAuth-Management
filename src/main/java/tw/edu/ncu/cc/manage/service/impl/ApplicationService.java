package tw.edu.ncu.cc.manage.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IApplicationDao;
import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.IApplicationService;
import tw.edu.ncu.cc.manage.service.oauth.connector.Connection;
import tw.edu.ncu.cc.manage.service.oauth.converter.ApplicationConverter;
import tw.edu.ncu.cc.manage.service.oauth.converter.ErrorMessageConverter;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ApplicationService implements IApplicationService {

	@Autowired
	private IApplicationDao applicationDao;

	public Connection connection;

	public ApplicationService() {
		connection = new Connection();
	}

	public boolean isAllowToAccess(Application app, String userid) {
		return app.getOwner().equals(userid);
	}

	public List<IdApplication> findAll(String userId) {
		return this.applicationDao.findAll(userId);
	}

	@Override
	public Optional<IdApplication> findById(String id) throws MalformedURLException, IOException {
		Optional<IdApplication> ida = Optional.empty();

		HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL + id), null, Connection.GET);
		connectionURL.connect();
		int status = connectionURL.getResponseCode();
		if (status == 200) {
			SecretIdApplication result = ApplicationConverter.convert(connection.getStringFromConnection(connectionURL));
			ida = Optional.ofNullable(result);
		}

		return ida;
	}

	@Override
	public Optional<IdApplication> update(IdApplication app) throws OAuthConnectionException, IOException {
		Optional<IdApplication> ida = Optional.empty();

		HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL + app.getId()), ApplicationConverter.convert(app), Connection.PUT);
		connectionURL.connect();
		int status = connectionURL.getResponseCode();

		if (status == 200) {
			ida = Optional.ofNullable(ApplicationConverter.convert(connection.getStringFromConnection(connectionURL)));
		}

		if (status == 400) {
			String content = connection.getStringFromErrorConnection(connectionURL);
			throw new OAuthConnectionException(ErrorMessageConverter.convert(content));
		}

		return ida;
	}

	public Optional<SecretIdApplication> create(Application app) throws OAuthConnectionException, JsonParseException, JsonMappingException,
			MalformedURLException, IOException {
		Optional<SecretIdApplication> sia = Optional.empty();
		HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL), ApplicationConverter.convert(app), Connection.POST);
		int status;

		status = connectionURL.getResponseCode();

		if (status == 200) {
			String content = connection.getStringFromConnection(connectionURL);
			sia = Optional.ofNullable(ApplicationConverter.convert(content));
		}
		if (status == 400) {
			String content = connection.getStringFromErrorConnection(connectionURL);
			throw new OAuthConnectionException(ErrorMessageConverter.convert(content));
		}
		return sia;
	}

	public IdApplication removeAPP(IdApplication app) throws IOException {
		return remove(app.getId());
	}

	public IdApplication remove(String id) throws IOException {
		IdApplication ida = null;
		HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL + id), null, Connection.DELETE);
		connectionURL.connect();
		int status = connectionURL.getResponseCode();
		if (status == 200) {
			ida = ApplicationConverter.convert(connection.getStringFromConnection(connectionURL));
		}
		return ida;
	}

	@Override
	public Optional<SecretIdApplication> refreshSecret(String id) throws MalformedURLException, IOException {
		Optional<SecretIdApplication> sia = Optional.empty();
		
		HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL + id + "/secret/"), null, Connection.POST);
		int status = connectionURL.getResponseCode();
		if (status == 200) {
			String content = connection.getStringFromConnection(connectionURL);
			sia = Optional.ofNullable(ApplicationConverter.convert(content));
		}

		return sia;
	}
}
