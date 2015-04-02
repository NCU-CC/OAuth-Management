package tw.edu.ncu.cc.manage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.entity.BaseBean;
import tw.edu.ncu.cc.manage.repository.IDao;

public abstract class ServiceImpl<T> implements IService<T> {

	protected IDao<T> dao;

	public T find(Class<T> clazz, int id) {
		return dao.find(clazz, id);
	}

	@Inject
	public void setDao(IDao<T> dao) {
		this.dao = dao;
	}

	public IDao<T> getDao() {
		return dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public abstract void create(T baseBean);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(T baseBean) {
		dao.save(baseBean);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(T baseBean) {
		dao.save(baseBean);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTotalCount(String query, Object... params) {
		return dao.getTotalCount(query, params);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> list(String query, int firstResult, int maxSize, Object... params) {
		return dao.list(query, firstResult, maxSize, params);
	}

}
