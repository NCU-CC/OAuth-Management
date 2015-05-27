package tw.edu.ncu.cc.manage.dao.support;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AbstractRestfulClientDao<T> {

	private RestTemplate template = new RestTemplate();

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public AbstractRestfulClientDao() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected T get(String urlString) {
		return template.getForObject(urlString, clazz);
	}

	protected List<T> getList(String urlString) {
		ParameterizedTypeReference<List<T>> myBean = new ParameterizedTypeReference<List<T>>() {};
		ResponseEntity<List<T>> response = template.exchange(urlString, HttpMethod.GET, null, myBean);
		return response.getBody();
	}

	protected T put(String urlString, T parametersObject) {
		template.put(urlString, parametersObject);
		return parametersObject;
	}
	
	protected T post(String urlString, T parametersObject) {
		return template.postForObject(urlString, parametersObject, clazz);
	}

	protected void delete(String urlString) {
		template.delete(urlString);
	}
}
