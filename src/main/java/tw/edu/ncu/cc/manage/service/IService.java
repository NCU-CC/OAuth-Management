package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
	public Optional<T> find(Class<T> clazz, int id);

	public void create(T t);

	public Optional<T> save(T t);

	public void delete(T t);

	public int getTotalCount(String query, Object... params);

	public List<T> list(String query, int firstResult, int maxSize, Object... params);

}
