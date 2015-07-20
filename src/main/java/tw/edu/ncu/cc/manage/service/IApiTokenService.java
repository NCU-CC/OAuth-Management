package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.ApiToken;

public interface IApiTokenService {

	/**
	 * 新增或搜尋已有的api token
	 * @param clientId
	 * @return
	 */
	ApiToken createOrFindByClient(String clientId);

	List<ApiToken> findAllByClient(String clientId);
	
	/**
	 * 更新token
	 * @param tokenId
	 * @return 
	 */
	ApiToken refresh(String tokenId);

	Optional<ApiToken> findByToken(String token);

}
