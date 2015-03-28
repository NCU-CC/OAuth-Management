package tw.edu.ncu.cc.manage.service.oauth;

import java.util.List;

import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IAPPService {
    public static final String SERVICEURL = "https://140.115.3.97/oauth/management/v1/application/";
    public static final String USERSERVICEURL = "https://140.115.3.97/oauth/management/v1/user/";
    boolean isAllowToAccess(Application app,String userid);
    List<IdApplication> getAllAPPsByUserId (String id);
    IdApplication getAPPbyAPPId(String id);
    IdApplication updateAPP(IdApplication app) throws OAuthConnectionException;
    IdApplication removeAPP(IdApplication app);
    IdApplication remove(String id);
    SecretIdApplication create(Application app) throws OAuthConnectionException;
    SecretIdApplication newSecret(String id);
}
