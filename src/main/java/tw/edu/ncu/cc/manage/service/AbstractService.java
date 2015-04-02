package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.dao.IDao;

public abstract class AbstractService<T> implements IService<T> {

	@Autowired
	protected IDao<T> dao;
	
	public Optional<T> find(Class<T> clazz, int id) {
		return this.dao.find(clazz, id);
	}

	@Transactional
	public Optional<T> save(T t) {
		return this.dao.save(t);
	}

	@Transactional
	public void delete(T t) {
		this.dao.delete(t);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTotalCount(String query, Object... params) {
		return this.dao.count(query, params);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> list(String query, int firstResult, int maxSize, Object... params) {
		return this.dao.list(query, firstResult, maxSize, params);
	}

}
