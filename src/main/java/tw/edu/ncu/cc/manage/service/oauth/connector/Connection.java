package tw.edu.ncu.cc.manage.service.oauth.connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;

public class Connection {
    private static final Logger logger = Logger.getLogger(Connection.class);
    public static final String POST ="POST";
    public static final String GET ="GET";
    public static final String PUT ="PUT";
    public static final String DELETE ="DELETE";
    static {        
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
        
        sc.init(null, new TrustManager[] { new TrustAllX509TrustManager() }, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier( new HostnameVerifier(){
            public boolean verify(String string,SSLSession ssls) {
                return true;
            }
        });
        } catch (NoSuchAlgorithmException e) {
            logger.error("there is error", e);
        } catch (KeyManagementException e) {
            logger.error("there is error", e);
        }
    }
    public HttpURLConnection doConnection(URL url,String content,String method) throws IOException{
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();        

      httpConn.setRequestMethod(method);
      httpConn.setDoOutput(true);
      httpConn.setDoInput(true);
      httpConn.setRequestProperty("Content-Type",
              "application/json; charset=utf-8 ");  
      if(content!=null && content.length()>0){
          OutputStream os= null;
          try{
              os = httpConn.getOutputStream();
              DataOutputStream wr = new DataOutputStream(os);
              BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
              writer.write(content);
              writer.flush();
          }finally{
              if(os!=null){
                  try{
                  os.close();
                  }catch(IOException e){
                      logger.error("there is an error",e);
                  }
              }
          }
      }
      return httpConn;
    }
    public String getStringFromConnection(HttpURLConnection connection) throws IOException{
        if(connection!=null){
            InputStream is = null ;
            try{
            is = connection.getInputStream();
            String result = getStringFromConnection(is);
            return result;
            }finally{
                if(is!=null){
                    try{
                        is.close();
                        }catch(IOException e){
                            logger.error("there is an error",e);
                        }
                }
            } 
        }
        return null;
    }
    public String getStringFromErrorConnection(HttpURLConnection connection) throws IOException{
        if(connection!=null){
            InputStream is =null;
            try{
                is = connection.getErrorStream();
                return  getStringFromConnection(is);
            }finally{
                if(is!=null){
                    try{
                        is.close();
                        }catch(IOException e){
                            logger.error("there is an error",e);
                        }
                }
            }  
        }
        return null;
    }
    private String getStringFromConnection(InputStream ins) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
        String all ="";
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            all += inputLine+"\n";
        in.close();
        return all;
    }
}
