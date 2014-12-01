package tw.edu.ncu.cc.manage.openid;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class OpenIDManager {
    private static OpenIDSetting setting;
    private static OpenIDSetting respone;
    private static final String CHARSET = "UTF-8";
    private static final String CORRECTRESPONE = "is_valid:true";

    public OpenIDManager() throws OpenIDException {
        if (setting == null) {
            setting = new OpenIDSettingLoader()
                    .getSetting("openidSetting.properties");
            respone = new OpenIDSettingLoader()
                    .getSetting("openidCheck.properties");
        }
    }

    public String getURLString() {
        return setting.getURLString();
    }

    public URL getURL() {
        return setting.getURL();
    }

    @SuppressWarnings("rawtypes")
    public boolean checkAuthentication(Map request) {
        return checkAuthenticationWithStringMap(convertMapToStringMap(request));
    }

    @SuppressWarnings("rawtypes")
    public String getStudentID(Map request) {
        return getIdentityID(request);
    }
    
    @SuppressWarnings("rawtypes")
    public String getIdentityID(Map request){
        Map<String, String> re = convertMapToStringMap(request);
        return getIDFromURL(re.get("openid.identity"));
        
    }
    private String getIDFromURL(String url){
        return url.split("user/")[1];
    }

    @SuppressWarnings("rawtypes")
    private Map<String, String> convertMapToStringMap(Map request) {
        Map<String, String> re = new HashMap<String, String>();
        for (Object oo : request.keySet()) {
            re.put((String) oo, ((String[]) request.get(oo))[0]);
        }
        return re;
    }

    public boolean checkAuthenticationWithStringMap(Map<String, String> request) {

        String url = setting.getProp().getProperty("openid.op_endpoint") + "?";
        String param;
        try {
            param = getSettingParameters();
            param = getIncomingParameters(param, request);
            URL obj = new URL(url + param);
            String text = getResultFromUrl(obj);
            if (isResultTrue(text)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isResultTrue(String text) {
        return text.trim().equals(CORRECTRESPONE);
    }

    private String getResultFromUrl(URL obj) throws IOException {
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        InputStream inputStream = con.getInputStream();
        String text = IOUtils.toString(inputStream, CHARSET);
        return text;
    }

    private String getIncomingParameters(String param,
            Map<String, String> request) throws UnsupportedEncodingException {
        String result = param;
        for (String key : respone.getProp().stringPropertyNames()) {
            String realKey = respone.getProp().getProperty(key);
            result += "&"
                    + realKey
                    + "="
                    + URLEncoder.encode(request.get(realKey.toString()),
                            CHARSET);

        }
        return result;
    }

    private String getSettingParameters() throws UnsupportedEncodingException {
        return String.format("openid.mode=check_authentication&"
                + "openid.return_to=%s&" + "openid.realm=%s", URLEncoder
                .encode(setting.getProp().getProperty("openid.return_to"),
                        CHARSET), URLEncoder.encode(setting.getProp()
                .getProperty("openid.realm"), CHARSET));
    }
}
