package tw.edu.ncu.cc.manage.service.oauth.exception;

import tw.edu.ncu.cc.manage.entity.oauth.OAuthErrorMessage;

public class OAuthConnectionException extends Throwable{
    private static final long serialVersionUID = 1L;
    private OAuthErrorMessage authErrorMessage;
    public OAuthConnectionException(OAuthErrorMessage authErrorMessage) {
        this.authErrorMessage=authErrorMessage;
    }
    public OAuthErrorMessage getAuthErrorMessage() {
        return authErrorMessage;
    }
    public void setAuthErrorMessage(OAuthErrorMessage authErrorMessage) {
        this.authErrorMessage = authErrorMessage;
    }
    
}
