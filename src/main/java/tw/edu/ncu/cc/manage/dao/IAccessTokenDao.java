package tw.edu.ncu.cc.manage.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IAccessTokenDao {
	List<AccessToken> findAll(String username) throws MalformedURLException, IOException;

	Optional<AccessToken> findById(String tokenId) throws IOException;

	void remove(AccessToken token) throws IOException, OAuthConnectionException;
}
