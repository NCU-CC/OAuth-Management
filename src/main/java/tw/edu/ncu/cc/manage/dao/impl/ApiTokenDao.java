package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tw.edu.ncu.cc.manage.dao.IApiTokenDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.ApiToken;

@Repository
public class ApiTokenDao extends AbstractOAuthServiceDao<ApiToken> implements IApiTokenDao {

	@Override
	public List<ApiToken> findByClient(String clientId) {
		Assert.hasText(clientId);
		return getList(joinUrl(clientUrl, clientId, "api_tokens"));
	}

}
