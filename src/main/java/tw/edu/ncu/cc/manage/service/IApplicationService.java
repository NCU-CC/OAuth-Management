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
	public static final String SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/application/";
	public static final String USER_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";

	boolean isAllowToAccess(Application app, String userid);

	List<IdApplication> findAll(String id);

	Optional<IdApplication> findById(String id) throws MalformedURLException, IOException;

	Optional<IdApplication> update(IdApplication app) throws OAuthConnectionException, IOException;

	IdApplication removeAPP(IdApplication app) throws IOException;

	IdApplication remove(String id) throws IOException;

	Optional<SecretIdApplication> create(Application app) throws OAuthConnectionException, JsonParseException, JsonMappingException, MalformedURLException, IOException;

	Optional<SecretIdApplication> refreshSecret(String id) throws MalformedURLException, IOException;
}
