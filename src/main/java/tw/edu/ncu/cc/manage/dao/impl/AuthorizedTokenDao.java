package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IAuthorizedTokenDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.AuthorizedToken;

@Repository
public class AuthorizedTokenDao extends AbstractOAuthServiceDao<AuthorizedToken> implements IAuthorizedTokenDao {

	private static final ParameterizedTypeReference<List<AuthorizedToken>> parameterizedTypeReference = new ParameterizedTypeReference<List<AuthorizedToken>>() {};
	
	@Override
	protected ParameterizedTypeReference<List<AuthorizedToken>> parameterizedTypeReferenceForList() {
		return parameterizedTypeReference;
	}
	
	@Override
	public List<AuthorizedToken> findByUsername(String username) {
		Assert.hasText(username);
		return getList(withUrl(userUrl(), username, "authorized_tokens"));
	}

	@Override
	public Optional<AuthorizedToken> find(String tokenId) {
		Assert.hasText(tokenId);
		return get(withUrl(tokenUrl(), tokenId));
	}

	@Override
	public void revoke(AuthorizedToken token) {
		Assert.notNull(token);
		Assert.hasText(token.getId());
		delete(withUrl(tokenUrl(), token.getId()));
	}
}
