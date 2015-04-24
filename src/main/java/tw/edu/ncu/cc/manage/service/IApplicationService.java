package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IApplicationService {
	public static final String SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/application/";
	public static final String USER_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";

	boolean isAllowToAccess(Application app, String userid);

	List<IdApplication> findAll(String id);

	Optional<IdApplication> findById(String id);

	IdApplication update(IdApplication app) throws OAuthConnectionException;

	IdApplication removeAPP(IdApplication app);

	IdApplication remove(String id);

	Optional<SecretIdApplication> create(Application app) throws OAuthConnectionException;

	Optional<SecretIdApplication> refreshSecret(String id);
}
