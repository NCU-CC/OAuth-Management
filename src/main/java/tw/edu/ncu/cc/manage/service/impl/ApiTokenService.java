package tw.edu.ncu.cc.manage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IApiTokenDao;
import tw.edu.ncu.cc.manage.domain.ApiToken;
import tw.edu.ncu.cc.manage.service.IApiTokenService;

@Service
public class ApiTokenService implements IApiTokenService {

	@Autowired
	private IApiTokenDao apiTokenDao;
	
	@Override
	public List<ApiToken> findAllByClient(String clientId) {
		return this.apiTokenDao.findByClient(clientId);
	}

	@Override
	public ApiToken createOrFindByClient(String clientId) {
		
		Optional<ApiToken> result = findAllByClient(clientId).stream().findFirst();
		
		if (result.isPresent()) {
			return result.get();
		} else {
			return this.apiTokenDao.create(clientId);
		}
	}

	@Override
	public ApiToken refresh(String tokenId) {
		return this.apiTokenDao.refresh(tokenId);
	}

	@Override
	public Optional<ApiToken> find(String token) {
		return this.apiTokenDao.find(token);
	}
}
