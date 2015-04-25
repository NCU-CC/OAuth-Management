package tw.edu.ncu.cc.manage.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IAccessTokenDao;
import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.service.ITokenService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

@Service
public class TokenService implements ITokenService {
	
	@Autowired
	private IAccessTokenDao tokenDao;
	
	@Override
	public List<AccessToken> findAll(String account) throws MalformedURLException, IOException {
		return tokenDao.findAll(account);
	}

	@Override
	public Optional<AccessToken> findById(String id) throws IOException {
		return tokenDao.findById(id);
	}
	
	@Override
	public void remove(AccessToken token) throws IOException, OAuthConnectionException {
		this.tokenDao.remove(token);
	}

	public boolean hasPermission(AccessToken app, String userid) {
		return app.getUser().equals(userid);
	}
}
