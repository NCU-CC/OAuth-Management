package tw.edu.ncu.cc.manage.service;

import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.User;
import tw.edu.ncu.cc.manage.exception.OAuthServiceUnavailableException;

public interface IUserService {

	Optional<User> find(String username) throws OAuthServiceUnavailableException;

	User create(User user) throws OAuthServiceUnavailableException;

}
