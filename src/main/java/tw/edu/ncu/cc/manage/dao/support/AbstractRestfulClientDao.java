package tw.edu.ncu.cc.manage.dao.support;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class AbstractRestfulClientDao<T> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractRestfulClientDao.class);
	
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
		
		ParameterizedTypeReference<List<T>> myBean = new ParameterizedTypeReference<List<T>>() {};
		ResponseEntity<List<T>> response = template.exchange(url, HttpMethod.GET, null, myBean);
		return response.getBody();
	}

	protected T put(String url, T parametersObject) {
		if (logger.isDebugEnabled()) {
			logger.debug("PUT {} with params {}", url, parametersObject);
		}
		
		template.put(url, parametersObject);
		return parametersObject;
	}
	
	protected T post(String url, T parametersObject) {
		if (logger.isDebugEnabled()) {
			logger.debug("POST {} with params {}", url);
		}
		
		return template.postForObject(url, parametersObject, clazz);
	}

	protected void delete(String url) {
		if (logger.isDebugEnabled()) {
			logger.debug("DELETE {}", url);
		}
		
		template.delete(url);
	}
}
