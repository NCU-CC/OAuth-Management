package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IAccessTokenDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.AccessToken;

@Repository
public class AccessTokenDao extends AbstractOAuthServiceDao<AccessToken> implements IAccessTokenDao {

	@Override
	public List<AccessToken> findAll(String username) {
		Assert.hasText(username);
		return getList(withUrl(userUrl, username, "access_tokens"));
	}

	@Override
	public Optional<AccessToken> find(String tokenId) {
		Assert.hasText(tokenId);
		return get(withUrl(accessTokenUrl, tokenId));
	}

	@Override
	public void revoke(AccessToken token) {
		Assert.notNull(token);
		Assert.hasText(token.getId());
		delete(withUrl(accessTokenUrl, token.getId()));
	}
}
