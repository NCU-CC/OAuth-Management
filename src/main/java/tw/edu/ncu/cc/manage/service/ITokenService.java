package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.AccessToken;

public interface ITokenService {

	List<AccessToken> findAll(String account);
	
	Optional<AccessToken> find(String id) ;

	void revoke(AccessToken app);
}
