package tw.edu.ncu.cc.manage.service.oauth.exception;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.edu.ncu.cc.manage.entity.oauth.OAuthErrorMessage;

public class OAuthConnectionException extends Throwable {
	private static final long serialVersionUID = 1L;
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	private OAuthErrorMessage authErrorMessage;

	public OAuthConnectionException(String errorMessage) throws JsonParseException, JsonMappingException, IOException {
		this.authErrorMessage = objectMapper.readValue(errorMessage, OAuthErrorMessage.class);  
	}
	
	public OAuthConnectionException(OAuthErrorMessage authErrorMessage) {
		this.authErrorMessage = authErrorMessage;
	}

	public OAuthErrorMessage getAuthErrorMessage() {
		return authErrorMessage;
	}

	public void setAuthErrorMessage(OAuthErrorMessage authErrorMessage) {
		this.authErrorMessage = authErrorMessage;
	}

}
