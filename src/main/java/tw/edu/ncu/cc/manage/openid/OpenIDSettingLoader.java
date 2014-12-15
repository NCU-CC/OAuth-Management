package tw.edu.ncu.cc.manage.openid;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class OpenIDSettingLoader {
    
    public OpenIDSettingLoader() {
    }

    public OpenIDSetting getSetting(String file) throws OpenIDException {
        ClassLoader classloader = Thread.currentThread()
                .getContextClassLoader();
        InputStream is=null;
        OpenIDSetting ois = null;
        try{
            is = classloader.getResourceAsStream(file);
            Properties prop = new Properties();
            try {
                prop.load(is);
            } catch (IOException e) {
                throw new OpenIDException("reading openid setting error");
            }
            ois= new OpenIDSetting(prop);
        }finally{
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    ois= null;
                }
            }
        }
        return ois;
    }
}
