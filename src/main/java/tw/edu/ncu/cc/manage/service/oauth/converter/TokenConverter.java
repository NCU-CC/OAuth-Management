package tw.edu.ncu.cc.manage.service.oauth.converter;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.edu.ncu.cc.manage.entity.oauth.token.AccessToken;

public class TokenConverter {
    public static String convert(AccessToken message) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(message);
    }
    
    public static AccessToken convert(String message) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(message, AccessToken.class);
    }
    public static List<AccessToken> convetList(String message) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(message, List.class);
    }
}
