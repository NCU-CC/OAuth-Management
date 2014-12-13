package tw.edu.ncu.cc.manage.openid;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class OpenIDSettingLoader {
    private static final Logger logger = Logger.getLogger(OpenIDSettingLoader.class);
    public OpenIDSettingLoader() {
    }

    public OpenIDSetting getSetting(String file) throws OpenIDException {
        ClassLoader classloader = Thread.currentThread()
                .getContextClassLoader();
        InputStream is=null;
        try{
            is = classloader.getResourceAsStream(file);
            Properties prop = new Properties();
            try {
                prop.load(is);
            } catch (IOException e) {
                throw new OpenIDException("reading openid setting error");
            }
            return new OpenIDSetting(prop);
        }finally{
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("there is an error",e);
                }
            }
        }
    }
}
