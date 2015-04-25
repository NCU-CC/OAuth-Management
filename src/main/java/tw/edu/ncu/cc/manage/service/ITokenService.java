package tw.edu.ncu.cc.manage.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.AccessToken;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface ITokenService {

	List<AccessToken> findAll(String account) throws MalformedURLException, IOException;

	Optional<AccessToken> findById(String id) throws IOException;

	void remove(AccessToken app) throws IOException, OAuthConnectionException;

	boolean hasPermission(AccessToken app, String userid);
}
