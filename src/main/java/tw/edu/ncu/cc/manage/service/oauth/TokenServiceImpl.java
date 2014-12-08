package tw.edu.ncu.cc.manage.service.oauth;

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
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(USERSERVICEURL+id+"/token"), null, Connection.GET);
            int status=connectionURL.getResponseCode();
            connectionURL.connect();
            if(status==200){
                return TokenConverter.convetList(connection.getStringFromConnection(connectionURL));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AccessToken getTokenbyTokenId(String id) {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(TOKENSERVICEURL+id), null, Connection.GET);
            int status=connectionURL.getResponseCode();
            connectionURL.connect();
            if(status==200){
                return TokenConverter.convert(connection.getStringFromConnection(connectionURL));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AccessToken removeToken(AccessToken app) {
        return removeToken(app.getId());
    }
    public AccessToken removeToken(String id) {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(TOKENSERVICEURL+id), null, Connection.DELETE);
            int status=connectionURL.getResponseCode();
            connectionURL.connect();
            if(status==200){
                return TokenConverter.convert(connection.getStringFromConnection(connectionURL));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean isAllowToAccess(AccessToken app, String userid) {
        return app.getUser().equals(userid);
    }

}
