package tw.edu.ncu.cc.manage.dao.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IAccessTokenDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

@Repository
public class AccessTokenDao extends AbstractOAuthServiceDao<AccessToken> implements IAccessTokenDao {

	@Override
	public List<AccessToken> findAll(String username) throws MalformedURLException, IOException {
		Assert.hasText(username);
		return getList(userUrl + username + "/access_tokens");
	}

	@Override
	public Optional<AccessToken> findById(String tokenId) throws IOException {
		Assert.hasText(tokenId);
		return Optional.ofNullable(get(accessTokenUrl + tokenId));
	}

	@Override
	public void remove(AccessToken token) throws IOException, OAuthConnectionException {
		Assert.notNull(token);
		Assert.hasText(token.getId());
		delete(accessTokenUrl + token.getId());
	}
}
