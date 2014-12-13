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

public class Connection {
    public static final String POST ="POST";
    public static final String GET ="GET";
    public static final String PUT ="PUT";
    public static final String DELETE ="DELETE";
    public static final int MAX_STRING_LENGTH = 10000;
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
            
        } catch (KeyManagementException e) {
            
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
          OutputStream os = httpConn.getOutputStream();
          DataOutputStream wr = new DataOutputStream(os);
          BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
          writer.write(content);
          writer.flush();
          writer.close();
          wr.close();
          os.close();
      }
      return httpConn;
    }
    public String getStringFromConnection(HttpURLConnection connection) throws IOException{
        InputStream is = connection.getInputStream();
        String result = getStringFromConnection(is);
        is.close();
        return result;
    }
    public String getStringFromErrorConnection(HttpURLConnection connection) throws IOException{
        InputStream is = connection.getErrorStream();
        String result = getStringFromConnection(is);
        is.close();
        return result;
    }
    private String getStringFromConnection(InputStream ins) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
        String all ="";
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            if(all.length()>MAX_STRING_LENGTH){
                break;
            }
            all += inputLine+"\n";
        in.close();
        return all;
    }
}
