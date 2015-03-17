package tw.edu.ncu.cc.manage.service.oauth;

import java.util.List;

import tw.edu.ncu.cc.manage.entity.oauth.token.AccessToken;

public interface ITokenService {
    public static final String USERSERVICEURL = "https://127.0.0.1/oauth/management/v1/user/";
    public static final String TOKENSERVICEURL = "https://127.0.0.1/oauth/management/v1/token/";
    List<AccessToken> getAllTokensByUserId (String id);
    AccessToken getTokenbyTokenId(String id);    
    AccessToken removeToken(AccessToken app);
    AccessToken removeToken(String id);
    boolean isAllowToAccess(AccessToken app,String userid);
}
