package tw.edu.ncu.cc.manage.openid;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.Set;

public class OpenIDSetting {
    
    private Properties prop;

    public OpenIDSetting(Properties properties) {
        this.prop = properties;
    }

    public URL getURL() {
        String endpoint = getURLString();
        URL url = null;
        try {
            url = new URL(endpoint);
        } catch (MalformedURLException e) {
            return url;
        }
        return url;
    }

    public String getURLString() {
        String endpoint = prop.getProperty("openid.op_endpoint") + "?";
        Set<String> names = prop.stringPropertyNames();
        String[] keys = names.toArray(new String[names.size()]);
        return addParameters(endpoint, keys);
    }

    private String addParameters(String url, String[] parameters) {
        String resultUrl = url;
        try {
            for (int i = 0; i < parameters.length - 1; i++) {
                resultUrl += parameters[i]
                        + "="
                        + URLEncoder.encode(prop.getProperty(parameters[i]),
                                "UTF-8") + "&";                
            }
            resultUrl += parameters[parameters.length - 1]
                    + "="
                    + URLEncoder
                            .encode(prop
                                    .getProperty(parameters[parameters.length - 1]),
                                    "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return resultUrl;
        }
        return resultUrl;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }
}
