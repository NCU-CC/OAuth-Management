package tw.edu.ncu.cc.manage.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IUserDao;
import tw.edu.ncu.cc.manage.domain.User;
import tw.edu.ncu.cc.manage.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public Optional<User> find(String username) {
		Assert.hasText(username);
		return this.userDao.find(username);
	}

	@Override
	public User create(User user) {
		Assert.notNull(user);
		return this.userDao.create(user);
	}
}
