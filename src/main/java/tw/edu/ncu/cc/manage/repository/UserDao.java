package tw.edu.ncu.cc.manage.repository;

import tw.edu.ncu.cc.manage.entity.User;

public interface UserDao {

	User persist(User user);
	
}
