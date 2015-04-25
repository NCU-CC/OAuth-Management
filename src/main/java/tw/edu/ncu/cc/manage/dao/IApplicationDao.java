package tw.edu.ncu.cc.manage.dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IApplicationDao {

	List<IdApplication> findAll(String username) throws IOException;

	Optional<IdApplication> findById(String applicationId) throws IOException;

	Optional<IdApplication> update(IdApplication application) throws IOException, OAuthConnectionException;

	Optional<IdApplication> create(Application application) throws IOException, OAuthConnectionException;

	void remove(IdApplication application) throws IOException, OAuthConnectionException;

	Optional<IdApplication> refreshSecret(String applicationId) throws IOException, OAuthConnectionException;

}
