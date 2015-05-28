package tw.edu.ncu.cc.manage.dao;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.AccessToken;

public interface IAccessTokenDao {
	List<AccessToken> findAll(String username);

	Optional<AccessToken> find(String tokenId);

	void revoke(AccessToken token);
}
