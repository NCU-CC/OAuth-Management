package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.AuthorizedToken;

public interface ITokenService {

	List<AuthorizedToken> findAll(String account);
	
	Optional<AuthorizedToken> find(String id) ;

	void revoke(AuthorizedToken app);
}
