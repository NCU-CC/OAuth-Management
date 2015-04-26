package tw.edu.ncu.cc.manage.dao.support;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.MalformedURLException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.utils.RestfulClientUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class AbstractRestfulClientDao<T> {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		SSLContext sc = null;
		try {
			sc = SSLContext.getInstance("TLS");

			sc.init(null, new TrustManager[] { new TrustAllX509TrustManager() }, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String string, SSLSession ssls) {
					return true;
				}
			});
		} catch (NoSuchAlgorithmException e) {
			sc = null;
		} catch (KeyManagementException e) {
			sc = null;
		}
	}
	
	private Class<T> clazz;
    
	@SuppressWarnings("unchecked")
	public AbstractRestfulClientDao() {
		 this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected T get(String urlString) throws IOException {		
		String response = RestfulClientUtils.get(urlString);
		return objectMapper.readValue(response, clazz);
	}
	
	protected List<T> getList(String urlString) throws MalformedURLException, IOException {
		String response = RestfulClientUtils.get(urlString);
		CollectionType collectionType = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clazz);
		List<T> list = objectMapper.readValue(response, collectionType);
		return Optional.ofNullable(list).orElse(Collections.emptyList());
	}
	
	protected T put(String urlString, Object parametersObject) throws IOException, OAuthConnectionException {
		String response = RestfulClientUtils.put(urlString, parametersObject);
		return objectMapper.readValue(response, clazz);
	}
	
	protected T post(String urlString) throws IOException, OAuthConnectionException {
		return post(urlString, null);
	}
	
	protected T post(String urlString, Object parametersObject) throws IOException, OAuthConnectionException {
		String response = RestfulClientUtils.post(urlString, parametersObject);
		return objectMapper.readValue(response, clazz);
	}
	
	protected void delete(String urlString) throws IOException, OAuthConnectionException {
		RestfulClientUtils.delete(urlString);
	}
}
