package tw.edu.ncu.cc.manage.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.service.ITokenService;
import tw.edu.ncu.cc.manage.service.oauth.connector.Connection;
import tw.edu.ncu.cc.manage.service.oauth.converter.TokenConverter;

@Service
public class TokenService implements ITokenService {
	
	private static final Logger logger = Logger.getLogger(TokenService.class);
	
	public Connection connection;

	public TokenService() {
		connection = new Connection();
	}

	public List<AccessToken> getAllTokensByUserId(String id) {
		List<AccessToken> tokenList = Collections.emptyList();
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(USER_SERVICE_URL + id + "/token"), null, Connection.GET);
			int status = connectionURL.getResponseCode();
			connectionURL.connect();
			if (status == 200) {
				tokenList = TokenConverter.convetList(connection.getStringFromConnection(connectionURL));
			}
		} catch (IOException e) {
			logger.info(e);
		}
		return tokenList;
	}

	public AccessToken getTokenbyTokenId(String id) {
		AccessToken accessToken = null;
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(TOKEN_SERVICE_URL + id), null, Connection.GET);
			int status = connectionURL.getResponseCode();
			connectionURL.connect();
			if (status == 200) {
				accessToken = TokenConverter.convert(connection.getStringFromConnection(connectionURL));
			}
		} catch (IOException e) {
			logger.info(e);
			accessToken = null;
		}
		return accessToken;
	}

	public AccessToken removeToken(AccessToken app) {
		return removeToken(app.getId());
	}

	public AccessToken removeToken(String id) {
		AccessToken accessToken = null;
		try {
			HttpURLConnection connectionURL = connection.doConnection(new URL(TOKEN_SERVICE_URL + id), null, Connection.DELETE);
			int status = connectionURL.getResponseCode();
			connectionURL.connect();
			if (status == 200) {
				accessToken = TokenConverter.convert(connection.getStringFromConnection(connectionURL));
			}
		} catch (IOException e) {
			logger.info(e);
			accessToken = null;
		}
		return accessToken;
	}

	public boolean isAllowToAccess(AccessToken app, String userid) {
		return app.getUser().equals(userid);
	}
}
