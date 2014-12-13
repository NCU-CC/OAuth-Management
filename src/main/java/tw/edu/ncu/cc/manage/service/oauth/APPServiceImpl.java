package tw.edu.ncu.cc.manage.service.oauth;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.oauth.connector.Connection;
import tw.edu.ncu.cc.manage.service.oauth.converter.ApplicationConverter;
import tw.edu.ncu.cc.manage.service.oauth.converter.ErrorMessageConverter;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

@Service
public class APPServiceImpl implements IAPPService{
    public Connection connection;
    public APPServiceImpl() {
        connection= new Connection();
    }
    public boolean isAllowToAccess(Application app, String userid) {
        return app.getOwner().equals(userid);
    }

    public List<IdApplication> getAllAPPsByUserId(String id) {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(USERSERVICEURL+id+"/application"), null, Connection.GET);
            connectionURL.connect();
            int status=connectionURL.getResponseCode();            
            if(status==200){                
                List<IdApplication> list =ApplicationConverter.convetList(connection.getStringFromConnection(connectionURL));
//                Collections.sort(list,new ApplicationComparator());
                return list;
            }            
        } catch (Exception e) {
        }
        return null;
    }

    public IdApplication getAPPbyAPPId(String id) {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(SERVICEURL+id), null, Connection.GET);
            connectionURL.connect();
            int status=connectionURL.getResponseCode();            
            if(status==200){
                return ApplicationConverter.convert(connection.getStringFromConnection(connectionURL));
            }            
        } catch (Exception e) {
        }
        return null;
    }

    public IdApplication updateAPP(IdApplication app) throws OAuthConnectionException {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(SERVICEURL+app.getId()), ApplicationConverter.convert(app), Connection.PUT);
            connectionURL.connect();
            int status=connectionURL.getResponseCode();            
            if(status==200){
                return ApplicationConverter.convert(connection.getStringFromConnection(connectionURL));
            }            
            if(status==400){
                String content =connection.getStringFromErrorConnection(connectionURL);
                throw new OAuthConnectionException(ErrorMessageConverter.convert(content));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public SecretIdApplication createAPP(Application app) throws OAuthConnectionException {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(SERVICEURL), ApplicationConverter.convert(app), Connection.POST);
            int status=connectionURL.getResponseCode();
            if(status==200){
                String content =connection.getStringFromConnection(connectionURL);
                return ApplicationConverter.convert(content);
            }                        
            if(status==400){
                String content =connection.getStringFromErrorConnection(connectionURL);
                throw new OAuthConnectionException(ErrorMessageConverter.convert(content));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public IdApplication removeAPP(IdApplication app) {
        return removeAPP(app.getId());
    }

    public IdApplication removeAPP(String id) {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(SERVICEURL+id), null, Connection.DELETE);
            connectionURL.connect();
            int status=connectionURL.getResponseCode();            
            if(status==200){
                return ApplicationConverter.convert(connection.getStringFromConnection(connectionURL));
            }            
        } catch (Exception e) {
        }
        return null;
    }
    public SecretIdApplication newSecret(String id) {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(SERVICEURL+id+"/secret/"), null , Connection.POST);
            int status=connectionURL.getResponseCode();
            if(status==200){
                String content =connection.getStringFromConnection(connectionURL);
                return ApplicationConverter.convert(content);
            }                   
        } catch (Exception e) {
        }
        return null;
    }
}
