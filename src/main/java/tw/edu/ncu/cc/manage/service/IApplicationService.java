package tw.edu.ncu.cc.manage.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tw.edu.ncu.cc.manage.entity.oauth.Application;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IApplicationService {

	boolean isAllowToAccess(Application application, String userid);

	List<Application> findAll(String username) throws IOException;

	Optional<Application> findById(String id) throws MalformedURLException, IOException;

	Optional<Application> update(Application application) throws OAuthConnectionException, IOException;

	void remove(Application application) throws IOException, OAuthConnectionException;

	Optional<Application> create(Application application) throws OAuthConnectionException, JsonParseException, JsonMappingException, MalformedURLException, IOException;

	Optional<Application> refreshSecret(String applicationId) throws MalformedURLException, IOException, OAuthConnectionException;
}
