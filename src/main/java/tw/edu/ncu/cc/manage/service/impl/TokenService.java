package tw.edu.ncu.cc.manage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IAuthorizedTokenDao;
import tw.edu.ncu.cc.manage.domain.AuthorizedToken;
import tw.edu.ncu.cc.manage.service.ITokenService;

@Service
public class TokenService implements ITokenService {
	
	@Autowired
	private IAuthorizedTokenDao tokenDao;
	
	@Override
	public List<AuthorizedToken> findAll(String account) {
		return tokenDao.findAll(account);
	}

	@Override
	public Optional<AuthorizedToken> find(String id) {
		return tokenDao.find(id);
	}
	
	@Override
	public void revoke(AuthorizedToken token) {
		this.tokenDao.revoke(token);
	}
}
