package tw.edu.ncu.cc.manage.service;

import java.util.List;

import tw.edu.ncu.cc.manage.entity.AccessToken;

public interface ITokenService {

	public static final String USER_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/user/";
	public static final String TOKEN_SERVICE_URL = "https://api.cc.ncu.edu.tw/oauth/management/v1/token/";

	List<AccessToken> findAll(String account);

	AccessToken getTokenbyTokenId(String id);

	AccessToken removeToken(AccessToken app);

	AccessToken removeToken(String id);

	boolean isAllowToAccess(AccessToken app, String userid);
}
