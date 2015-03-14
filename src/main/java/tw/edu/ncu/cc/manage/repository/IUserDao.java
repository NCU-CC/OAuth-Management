package tw.edu.ncu.cc.manage.repository;

import tw.edu.ncu.cc.manage.entity.User;

public interface IUserDao {

	User persist(User user);
	
}
