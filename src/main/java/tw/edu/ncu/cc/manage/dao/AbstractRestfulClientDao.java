package tw.edu.ncu.cc.manage.dao;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class AbstractRestfulClientDao<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractRestfulClientDao.class);
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	private Class<T> clazz;
    
	@SuppressWarnings("unchecked")
	public AbstractRestfulClientDao() {
		 this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected T get(String urlString) throws IOException {
		logger.debug("GET url={}", urlString);
		
		String response = IOUtils.toString(new URL(urlString), "UTF-8");
		return objectMapper.readValue(response, clazz);
	}
	
	protected List<T> getList(String urlString) throws MalformedURLException, IOException {
		logger.debug("GET list of entity, url={}", urlString);
		
		String response = IOUtils.toString(new URL(urlString), "UTF-8");
		CollectionType collectionType = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clazz);
		List<T> list = objectMapper.readValue(response, collectionType);
		return Optional.ofNullable(list).orElse(Collections.emptyList());
	}
	
	protected T put(String urlString, Object parametersObject) throws IOException, OAuthConnectionException {
		logger.debug("PUT url={}, parameters={}", urlString, parametersObject);
		
		String response = connectUrl("PUT", urlString, parametersObject);
		return objectMapper.readValue(response, clazz);
	}
	
	protected T post(String urlString) throws IOException, OAuthConnectionException {
		return post(urlString, null);
	}
	
	protected T post(String urlString, Object parametersObject) throws IOException, OAuthConnectionException {
		logger.debug("POST url={}, parameters={}", urlString, parametersObject);
		
		String response = connectUrl("POST", urlString, parametersObject);
		return objectMapper.readValue(response, clazz);
	}
	
	protected void delete(String urlString) throws IOException, OAuthConnectionException {
		logger.debug("DELETE url={}", urlString);
		
		connectUrl("DELETE", urlString, null);
	}
	
	private String connectUrl(String methodName, String urlString, Object parametersObject) throws IOException, OAuthConnectionException {
		
		URL url = new URL(urlString);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(methodName);
		
		if (parametersObject != null) {
			conn.setRequestProperty("Content-Type", "application/json");	
			String parametersString = objectMapper.writeValueAsString(parametersObject);
			IOUtils.copy(IOUtils.toInputStream(parametersString), conn.getOutputStream());
		}
		
		String response = IOUtils.toString(conn.getInputStream());
		
		conn.disconnect();
		
		if (conn.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) {
			throw new OAuthConnectionException(response);
		}
		
		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		
		return response;
	}
	
}
