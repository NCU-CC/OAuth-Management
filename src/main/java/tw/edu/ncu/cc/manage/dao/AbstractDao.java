package tw.edu.ncu.cc.manage.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class AbstractDao<T> implements IDao<T> {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Optional<T> find(Class<T> clazz, int id) {
		return Optional.ofNullable(this.entityManager.find(clazz, id));
	}

	public void create(T t) {
		this.entityManager.persist(t);
	}

	public Optional<T> save(T t) {
		return Optional.ofNullable(this.entityManager.merge(t));
	}

	public void delete(T t) {
		this.entityManager.remove(t);
	}

	public int count(String hql, Object... params) {
		Query query = createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		Object object = createQuery(hql).getFirstResult();
		return ((Long) object).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, int firstResult, int maxSize, Object... params) {
		Query query = createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		List<T> list = createQuery(hql).setFirstResult(firstResult).setMaxResults(maxSize).getResultList();
		return Optional.ofNullable(list).orElse(Collections.emptyList());
	}

	public Query createQuery(String hql) {
		return entityManager.createQuery(hql);
	}

}
