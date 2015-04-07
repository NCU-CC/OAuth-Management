package tw.edu.ncu.cc.manage.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.IApplicationService;
import tw.edu.ncu.cc.manage.service.oauth.connector.Connection;
import tw.edu.ncu.cc.manage.service.oauth.converter.ApplicationConverter;
import tw.edu.ncu.cc.manage.service.oauth.converter.ErrorMessageConverter;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

@Service
public class ApplicationService implements IApplicationService {
	
	private static final Logger logger = Logger.getLogger(ApplicationService.class);
	
	public Connection connection;

	public ApplicationService() {
		connection = new Connection();
	}

	public boolean isAllowToAccess(Application app, String userid) {
		return app.getOwner().equals(userid);
	}

	public List<IdApplication> getAllAPPsByUserId(String id) {
		List<IdApplication> list = Collections.emptyList();
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(USER_SERVICE_URL + id + "/application"), null, Connection.GET);
			connectionURL.connect();
			int status = connectionURL.getResponseCode();
			if (status == 200) {
				list = ApplicationConverter.convetList(connection.getStringFromConnection(connectionURL));
			}
		} catch (IOException e) {
			logger.warn(e);
		}
		return list;
	}

	public IdApplication getAPPbyAPPId(String id) {
		IdApplication ida = null;
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL + id), null, Connection.GET);
			connectionURL.connect();
			int status = connectionURL.getResponseCode();
			if (status == 200) {
				ida = ApplicationConverter.convert(connection.getStringFromConnection(connectionURL));
			}
		} catch (IOException e) {
			logger.warn(e);
		}
		return ida;
	}

	public IdApplication update(IdApplication app) throws OAuthConnectionException {
		IdApplication ida = null;
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL + app.getId()), ApplicationConverter.convert(app), Connection.PUT);
			connectionURL.connect();
			int status = connectionURL.getResponseCode();
			if (status == 200) {
				ida = ApplicationConverter.convert(connection.getStringFromConnection(connectionURL));
			}
			if (status == 400) {
				String content = connection.getStringFromErrorConnection(connectionURL);
				throw new OAuthConnectionException(ErrorMessageConverter.convert(content));
			}
		} catch (IOException e) {
			logger.warn(e);
		}
		return ida;
	}

	public SecretIdApplication create(Application app) throws OAuthConnectionException {
		SecretIdApplication sia = null;
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL), ApplicationConverter.convert(app), Connection.POST);
			int status;

			status = connectionURL.getResponseCode();

			if (status == 200) {
				String content = connection.getStringFromConnection(connectionURL);
				sia = ApplicationConverter.convert(content);
			}
			if (status == 400) {
				String content = connection.getStringFromErrorConnection(connectionURL);
				throw new OAuthConnectionException(ErrorMessageConverter.convert(content));
			}
		} catch (IOException e) {
			logger.warn(e);
		}
		return sia;
	}

	public IdApplication removeAPP(IdApplication app) {
		return remove(app.getId());
	}

	public IdApplication remove(String id) {
		IdApplication ida = null;
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL + id), null, Connection.DELETE);
			connectionURL.connect();
			int status = connectionURL.getResponseCode();
			if (status == 200) {
				ida = ApplicationConverter.convert(connection.getStringFromConnection(connectionURL));
			}
		} catch (IOException e) {
			logger.warn(e);
		}
		return ida;
	}

	public SecretIdApplication newSecret(String id) {
		SecretIdApplication sia = null;
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(SERVICE_URL + id + "/secret/"), null, Connection.POST);
			int status = connectionURL.getResponseCode();
			if (status == 200) {
				String content = connection.getStringFromConnection(connectionURL);
				sia = ApplicationConverter.convert(content);
			}
		} catch (IOException e) {
			logger.warn(e);
		}
		return sia;
	}
}
