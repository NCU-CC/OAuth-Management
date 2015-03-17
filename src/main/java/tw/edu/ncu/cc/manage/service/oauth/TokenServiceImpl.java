package tw.edu.ncu.cc.manage.service.oauth;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.entity.oauth.token.AccessToken;
import tw.edu.ncu.cc.manage.service.oauth.connector.Connection;
import tw.edu.ncu.cc.manage.service.oauth.converter.TokenConverter;
@Service
public class TokenServiceImpl implements ITokenService{
    public Connection connection;
    public TokenServiceImpl() {
        connection= new Connection();
    }
    public List<AccessToken> getAllTokensByUserId(String id) {
        List<AccessToken> list = null;
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(USERSERVICEURL+id+"/token"), null, Connection.GET);
            int status=connectionURL.getResponseCode();
            connectionURL.connect();
            if(status==200){
                list= TokenConverter.convetList(connection.getStringFromConnection(connectionURL));
            }            
        } catch (IOException e) {
            list=null;
        }
        return list;
    }

    public AccessToken getTokenbyTokenId(String id) {
        AccessToken at = null;
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(TOKENSERVICEURL+id), null, Connection.GET);
            int status=connectionURL.getResponseCode();
            connectionURL.connect();
            if(status==200){
                at= TokenConverter.convert(connection.getStringFromConnection(connectionURL));
            }            
        } catch (IOException e) {
            at=null;
        }
        return at;
    }

    public AccessToken removeToken(AccessToken app) {
        return removeToken(app.getId());
    }
    public AccessToken removeToken(String id) {
        AccessToken at = null;
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(TOKENSERVICEURL+id), null, Connection.DELETE);
            int status=connectionURL.getResponseCode();
            connectionURL.connect();
            if(status==200){
                at= TokenConverter.convert(connection.getStringFromConnection(connectionURL));
            }            
        } catch (IOException e) {
            at = null;
        }
        return at;
    }
    public boolean isAllowToAccess(AccessToken app, String userid) {
        return app.getUser().equals(userid);
    }

}
