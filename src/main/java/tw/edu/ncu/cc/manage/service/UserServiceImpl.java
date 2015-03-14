package tw.edu.ncu.cc.manage.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.entity.User;
import tw.edu.ncu.cc.manage.repository.IUserDao;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	private IUserDao userDao;
	
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(User user) {
		userDao.persist(user);
	}

}