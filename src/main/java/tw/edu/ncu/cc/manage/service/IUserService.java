package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.User;
import tw.edu.ncu.cc.manage.exception.OAuthServiceUnavailableException;

public interface IUserService {

	Optional<User> find(String username) throws OAuthServiceUnavailableException;

	User create(User user) throws OAuthServiceUnavailableException;

	List<User> search(User dto);

}
