package tw.edu.ncu.cc.manage.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tw.edu.ncu.cc.manage.entity.User;
import tw.edu.ncu.cc.manage.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public User persist(User user) {
		entityManager.persist(user);
		return user;
	}

}
