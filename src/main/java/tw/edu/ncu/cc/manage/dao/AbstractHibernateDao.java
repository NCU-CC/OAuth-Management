package tw.edu.ncu.cc.manage.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractHibernateDao {
	
	@Autowired
    private SessionFactory sessionFactory;
 
	
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	public Optional<Object> find(Class<?> clazz, int id) {
		return Optional.ofNullable(getSession().get(clazz, id));
	}

	public void create(Object entity) {
		this.getSession().persist(entity);
	}

	public Optional<Object> save(Object entity) {
		return Optional.ofNullable(this.getSession().save(entity));
	}

	public void delete(Object entity) {
		this.getSession().delete(entity);
	}

}
