package tw.edu.ncu.cc.manage.dao;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.AccessToken;

public interface ITokenDao {
	List<AccessToken> findAll(String account);

	Optional<AccessToken> findById(String id);
}
