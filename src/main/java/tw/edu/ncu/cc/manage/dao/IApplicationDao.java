package tw.edu.ncu.cc.manage.dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.entity.oauth.Application;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;

public interface IApplicationDao {

	List<Application> findAll(String username) throws IOException;

	Optional<Application> findById(String applicationId) throws IOException;

	Optional<Application> update(Application application) throws IOException, OAuthConnectionException;

	Optional<Application> create(Application application) throws IOException, OAuthConnectionException;

	void remove(Application application) throws IOException, OAuthConnectionException;

	Optional<Application> refreshSecret(String applicationId) throws IOException, OAuthConnectionException;

}
