package tw.edu.ncu.cc.manage.dao;

import java.util.List;

import tw.edu.ncu.cc.manage.domain.ApiToken;

public interface IApiTokenDao {

	List<ApiToken> findByClient(String clientId);

}
