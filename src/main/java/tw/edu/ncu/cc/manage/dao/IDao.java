package tw.edu.ncu.cc.manage.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

public interface IDao<T> {
	public Optional<T> find(Class<T> clazz, int id);

	public void create(T t);

	public Optional<T> save(T t);

	public void delete(T t);

	public int count(String hql, Object... params);

	public List<T> list(String hql, int firstResult, int maxSize, Object... params);

	public Query createQuery(String hql);
}
