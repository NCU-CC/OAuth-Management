package tw.edu.ncu.cc.manage.dao;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.AuthorizedToken;

public interface IAuthorizedTokenDao {
	List<AuthorizedToken> findAll(String username);

	Optional<AuthorizedToken> find(String tokenId);

	void revoke(AuthorizedToken token);
}
