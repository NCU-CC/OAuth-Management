package tw.edu.ncu.cc.manage.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestfulClientUtils {

	private static final Logger logger = LoggerFactory.getLogger(RestfulClientUtils.class);
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static <E> E convert(String jsonString, Class<E> clazz) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(jsonString, clazz);
	}
	
	public static String get(String urlString) throws IOException {
		logger.debug("GET url={}", urlString);
		return IOUtils.toString(new URL(urlString), "UTF-8");
	}

	public static String put(String urlString, Object parametersObject) throws IOException, OAuthConnectionException {
		logger.debug("PUT url={}, parameters={}", urlString, parametersObject);
		return connectUrl("PUT", urlString, parametersObject);
	}

	public static String post(String urlString) throws IOException, OAuthConnectionException {
		return post(urlString, null);
	}

	public static String post(String urlString, Object parametersObject) throws IOException, OAuthConnectionException {
		logger.debug("POST url={}, parameters={}", urlString, parametersObject);
		return connectUrl("POST", urlString, parametersObject);
	}

	public static void delete(String urlString) throws IOException, OAuthConnectionException {
		logger.debug("DELETE url={}", urlString);
		connectUrl("DELETE", urlString, null);
	}

	private static String connectUrl(String methodName, String urlString, Object parametersObject) throws IOException, OAuthConnectionException {

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
