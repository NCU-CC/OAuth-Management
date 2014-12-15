package tw.edu.ncu.cc.manage.openid;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class OpenIDManager {    
    private static OpenIDSetting setting;
    private static final String CHARSET = "UTF-8";
    private static final String CORRECTRESPONE = "is_valid:true";

    public OpenIDManager() throws OpenIDException {
        if (setting == null) {
            setting = new OpenIDSettingLoader()
                    .getSetting("openidSetting.properties");
        }
    }   
    
    public String getURLString() {
        return setting.getURLString();
    }
    
    public boolean checkAuthentication(HttpServletRequest request) {
        boolean flag= false;
        try {
            String checkUrl = createCheckUrl(request);
            String result =getResultFromUrl(new URL(checkUrl));
            if (isResultTrue(result)) {
                flag= true;
            }
        } catch (IOException e) {
            flag= false;
        }
        return flag;
    }
    
    @SuppressWarnings("rawtypes")
    public String getIdentityID(HttpServletRequest request){
        Map map =request.getParameterMap();
        if(map!=null){
            Map<String, String> re = convertMapToStringMap(map);
            return getIDFromURL(re.get("openid.identity"));
        }
        return null;        
    }
    private String getIDFromURL(String url){
        return url.split("user/")[1];
    }
    
    private String createCheckUrl(HttpServletRequest request) throws UnsupportedEncodingException{
        StringBuffer receivingURL =new StringBuffer(setting.getProp().getProperty("openid.op_endpoint"));
        receivingURL.append("?openid.mode=check_authentication");
       
        receivingURL.append("&openid.realm="+URLEncoder.encode(setting.getProp().getProperty("openid.realm"), CHARSET));        
        String queryString = getQueryStringFromRequest(request);
        receivingURL.append(queryString);
            return receivingURL.toString();        
    }

    @SuppressWarnings("rawtypes")
    private Map<String, String> convertMapToStringMap(Map request) {
        Map<String, String> re = new HashMap<String, String>();
        for (Object oo : request.keySet()) {
            re.put((String) oo, ((String[]) request.get(oo))[0]);
        }
        return re;
    }
    
    @SuppressWarnings("rawtypes")
    private String getQueryStringFromRequest(HttpServletRequest request) throws UnsupportedEncodingException{
        StringBuffer tmp = new StringBuffer();
        Map map =request.getParameterMap();
        if(map!=null){
            Set keys = map.keySet();
            for(Object keyObject : keys){
                String key = (String) keyObject;
                if(!key.equals("openid.ns") && !key.equals("openid.mode") ){
                    tmp.append("&").append(key).append("=").append(  getEncodedString( ((String [])map.get(key))[0] ) );
                }
            }
            return tmp.toString();
        }
        return null;
    }

    private String getEncodedString(String originalString) throws UnsupportedEncodingException{
        return URLEncoder.encode(originalString,CHARSET);
    }
    
    private boolean isResultTrue(String text) {
        return text.trim().equals(CORRECTRESPONE);
    }

    private String getResultFromUrl(URL obj) throws IOException {
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        InputStream inputStream=null;
        String text=null;
        try{
            inputStream = con.getInputStream();
            text = IOUtils.toString(inputStream, CHARSET);
        }finally{
            if(inputStream!=null){
                try{
                    inputStream.close();
                    }catch(IOException e){
                        text=null;
                    }
            }
        }        
        return text;
    }

}
