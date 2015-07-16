package tw.edu.ncu.cc.manage.dao;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.ApiToken;

public interface IApiTokenDao {

	List<ApiToken> findByClient(String clientId);

	ApiToken create(String clientId);

	void revoke(ApiToken token);

	Optional<ApiToken> find(String token);

	ApiToken refresh(String tokenId);

}
