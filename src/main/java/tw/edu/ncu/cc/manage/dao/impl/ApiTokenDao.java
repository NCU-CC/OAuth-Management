package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IApiTokenDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.ApiToken;

@Repository
public class ApiTokenDao extends AbstractOAuthServiceDao<ApiToken> implements IApiTokenDao {

	@Override
	public List<ApiToken> findByClient(String clientId) {
		Assert.hasText(clientId);
		return getList(withUrl(clientUrl, clientId, "api_tokens"));
	}
	
	@Override
	public Optional<ApiToken> findByToken(String token) {
		Assert.hasText(token);
		return get(withUrl(apiTokenUrl, token));
	}
	
	@Override
	public ApiToken create(String clientId) {
		Assert.hasText(clientId);
		return post(withUrl(apiTokenUrl, "?client_id=" + clientId));
	}

	@Override
	public void remove(ApiToken token) {
		Assert.notNull(token);
		delete(withUrl(apiTokenUrl, token.getId()));
	}

	@Override
	public ApiToken refresh(String tokenId) {
		Assert.hasText(tokenId);
		return post(withUrl(apiTokenUrl, tokenId, "refresh"));
	}
	
}
