package tw.edu.ncu.cc.manage.dao.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IAccessTokenDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractRestfulClientDao;
import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.utils.SystemConstant;

@Repository
public class AccessTokenDao extends AbstractRestfulClientDao<AccessToken> implements IAccessTokenDao {

	@Override
	public List<AccessToken> findAll(String username) throws MalformedURLException, IOException {
		Assert.hasText(username);
		return getList(SystemConstant.OAUTH_USER_SERVICE_URL + username + "/access_tokens");
	}

	@Override
	public Optional<AccessToken> findById(String tokenId) throws IOException {
		Assert.hasText(tokenId, "Token id must not be null or empty.");
		return Optional.ofNullable(get(SystemConstant.OAUTH_TOKEN_SERVICE_URL + tokenId));
	}

	@Override
	public void remove(AccessToken token) throws IOException, OAuthConnectionException {
		Assert.notNull(token);
		Assert.hasText(token.getId());
		delete(SystemConstant.OAUTH_TOKEN_SERVICE_URL + token.getId());
	}
}
