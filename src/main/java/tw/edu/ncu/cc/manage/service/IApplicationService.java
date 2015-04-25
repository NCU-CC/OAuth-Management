package tw.edu.ncu.cc.manage.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IApplicationService {

	boolean isAllowToAccess(Application application, String userid);

	List<IdApplication> findAll(String username) throws IOException;

	Optional<IdApplication> findById(String id) throws MalformedURLException, IOException;

	Optional<IdApplication> update(IdApplication application) throws OAuthConnectionException, IOException;

	void remove(IdApplication application) throws IOException, OAuthConnectionException;

	Optional<IdApplication> create(Application application) throws OAuthConnectionException, JsonParseException, JsonMappingException, MalformedURLException, IOException;

	Optional<SecretIdApplication> refreshSecret(String applicationId) throws MalformedURLException, IOException, OAuthConnectionException;
}
