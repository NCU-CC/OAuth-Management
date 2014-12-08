package tw.edu.ncu.cc.manage.service.oauth.converter;

import java.io.IOException;

import tw.edu.ncu.cc.manage.entity.oauth.OAuthErrorMessage;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorMessageConverter {
    public static OAuthErrorMessage convert(String message) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(message, OAuthErrorMessage.class);        
    }
    public static String convert(OAuthErrorMessage app) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(app); 
    }
}
