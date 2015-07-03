package tw.edu.ncu.cc.manage.dao.support;

import java.lang.reflect.ParameterizedType;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestfulClientDao<T> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractRestfulClientDao.class);

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

	private RestTemplate template = new RestTemplate();

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public AbstractRestfulClientDao() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Optional<T> get(String url) {
		if (logger.isDebugEnabled()) {
			logger.debug("GET {}", url);
		}

		T t = null;
		try {
			t = template.getForObject(url, clazz);
		} catch (HttpClientErrorException e) {
			if (is404(e)) {
				logger.error("找不到資料");
				return Optional.empty();
			}
			throw e;
		}
		return Optional.ofNullable(t);
	}
	
	private boolean is404(HttpClientErrorException e) {
		return HttpStatus.NOT_FOUND.equals(e.getStatusCode());
	}

	protected List<T> getList(String url) {
		if (logger.isDebugEnabled()) {
			logger.debug("GET {}", url);
		}
		
		ResponseEntity<List<T>> response = template.exchange(url, HttpMethod.GET, null, parameterizedTypeReferenceForList());
		return response.getBody();
	}
	
	protected abstract ParameterizedTypeReference<List<T>> parameterizedTypeReferenceForList();

	protected T put(String url, T parametersObject) {
		if (logger.isDebugEnabled()) {
			logger.debug("PUT {} with params {}", url, parametersObject);
		}

		template.put(url, parametersObject);
		return parametersObject;
	}

	protected T post(String url) {
		return post(url, null, Collections.emptyMap());
	}

	protected T post(String url, T parametersObject) {
		return post(url, parametersObject, Collections.emptyMap());
	}

	protected T post(String url, Map<String, ?> uriParameters) {
		return post(url, null, uriParameters);
	}
	
	protected T post(String url, T parametersObject, Map<String, ?> uriParameters) {
		if (logger.isDebugEnabled()) {
			logger.debug("POST {} with uri params {}, body params {} ", url, uriParameters, parametersObject);
		}
		
		return template.postForObject(url, parametersObject, clazz, uriParameters);
	}
	
	protected void delete(String url) {
		if (logger.isDebugEnabled()) {
			logger.debug("DELETE {}", url);
		}

		template.delete(url);
	}

	protected String withUrl(String... strs) {
		return StringUtils.join(strs, "/");
	}
}