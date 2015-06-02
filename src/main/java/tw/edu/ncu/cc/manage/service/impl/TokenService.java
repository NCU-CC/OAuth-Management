package tw.edu.ncu.cc.manage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IAccessTokenDao;
import tw.edu.ncu.cc.manage.domain.AccessToken;
import tw.edu.ncu.cc.manage.service.ITokenService;

@Service
public class TokenService implements ITokenService {
	
	@Autowired
	private IAccessTokenDao tokenDao;
	
	@Override
	public List<AccessToken> findAll(String account) {
		return tokenDao.findAll(account);
	}

	@Override
	public Optional<AccessToken> find(String id) {
		return tokenDao.find(id);
	}
	
	@Override
	public void revoke(AccessToken token) {
		this.tokenDao.revoke(token);
	}
}
