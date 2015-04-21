package tw.edu.ncu.cc.manage.dao.impl;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.ITokenDao;
import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.service.oauth.converter.TokenConverter;

@Repository
public class TokenDao implements ITokenDao {

	private static final Logger logger = Logger.getLogger(TokenDao.class);
	
	private static final String USER_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";
	private static final String TOKEN_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/token/";

	private static final String ENCODE = "UTF-8";
	
	@Override
	public List<AccessToken> findAll(String account) {
		Assert.hasText(account, "Account must not be null or empty.");
		
		List<AccessToken> tokenList = Collections.emptyList();
		try {
			String response = IOUtils.toString(new URL(USER_SERVICE_URL + account + "/access_tokens"), ENCODE);
			tokenList = TokenConverter.convetList(response);
		} catch (IOException e) {
			logger.info(e);
		}
		return tokenList;
	}

	@Override
	public Optional<AccessToken> findById(String id) {
		Assert.hasText(id, "Token id must not be null or empty.");
		
		AccessToken accessToken = null;
		try {
			String response = IOUtils.toString(new URL(TOKEN_SERVICE_URL + id), ENCODE);
			accessToken = TokenConverter.convert(response);
		} catch (IOException e) {
			logger.info(e);
		}
		return Optional.ofNullable(accessToken);
	}

}
