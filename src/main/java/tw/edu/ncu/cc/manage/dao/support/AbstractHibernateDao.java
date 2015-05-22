package tw.edu.ncu.cc.manage.dao.support;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractHibernateDao<T> {
	
	@Autowired
    private SessionFactory sessionFactory;
 
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public AbstractHibernateDao() {
		 this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	@SuppressWarnings("unchecked")
	public Optional<T> find(int id) {
		return (Optional<T>) Optional.ofNullable(getSession().get(clazz, id));
	}

	public T create(T entity) {
		this.getSession().persist(entity);
		return entity;
	}

	public Optional<T> save(T entity) {
		this.getSession().persist(entity);
		return Optional.of(entity);
	}

	public void delete(T entity) {
		this.getSession().delete(entity);
	}

}
