package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.util.UriComponentsBuilder;

import tw.edu.ncu.cc.manage.dao.IBlacklistClientDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.BlacklistClient;
import tw.edu.ncu.cc.manage.domain.Client;

@Repository
public class BlacklistClientDao  extends AbstractOAuthServiceDao<BlacklistClient> implements IBlacklistClientDao {

	private static final ParameterizedTypeReference<List<BlacklistClient>> parameterizedTypeReference = new ParameterizedTypeReference<List<BlacklistClient>>() {};
	
	@Override
	protected ParameterizedTypeReference<List<BlacklistClient>> parameterizedTypeReferenceForList() {
		return parameterizedTypeReference;
	}

	@Override
	public Optional<BlacklistClient> find(String clientId) {
		return get(withUrl(blacklistClientUrl(), clientId));
	}
	
	@Override
	public BlacklistClient update(BlacklistClient client) {
		return put(withUrl(blacklistClientUrl(), client.getClient_id()), client);
	}
	
	@Override
	public List<BlacklistClient> search(Client dto) {
		
		String url = UriComponentsBuilder.fromHttpUrl(blacklistClientUrl())
				.queryParam("client_name", dto.getName())
				.queryParam("client_id", dto.getId())
				.queryParam("client_owner", dto.getOwner())
				.queryParam("client_deleted", dto.isDeleted())
				.build(false).toUriString();
		
		return getList(url);
	}

	@Override
	public BlacklistClient create(BlacklistClient client) {
		return post(blacklistClientUrl(), client);
	}

	@Override
	public void remove(BlacklistClient client) {
		delete(withUrl(blacklistClientUrl(), client.getClient_id()));
	}

}
