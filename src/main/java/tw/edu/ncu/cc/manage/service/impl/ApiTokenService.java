package tw.edu.ncu.cc.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IApiTokenDao;
import tw.edu.ncu.cc.manage.domain.ApiToken;
import tw.edu.ncu.cc.manage.service.IApiTokenService;

@Service
public class ApiTokenService implements IApiTokenService {

	@Autowired
	private IApiTokenDao apiTokenDao;
	
	public List<ApiToken> findByClient(String clientId) {
		return this.apiTokenDao.findByClient(clientId);
	}
}
