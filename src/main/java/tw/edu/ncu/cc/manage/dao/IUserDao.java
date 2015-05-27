package tw.edu.ncu.cc.manage.dao;

import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.User;

public interface IUserDao {

	Optional<User> find(String account);

	User create(User user);

}
