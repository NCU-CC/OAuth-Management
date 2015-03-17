package tw.edu.ncu.cc.manage.service.oauth.converter;

import java.io.IOException;

import tw.edu.ncu.cc.manage.entity.oauth.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserConverter {
    public static User convert(String message) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(message, User.class);        
    }
    public static String convert(User app) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(app); 
    }
}
