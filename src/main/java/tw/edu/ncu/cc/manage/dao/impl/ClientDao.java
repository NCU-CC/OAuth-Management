package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import tw.edu.ncu.cc.manage.dao.IClientDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.Client;

@Repository
public class ClientDao extends AbstractOAuthServiceDao<Client> implements IClientDao {
	
	private static final ParameterizedTypeReference<List<Client>> parameterizedTypeReference = new ParameterizedTypeReference<List<Client>>() {};
	
	@Override
	protected ParameterizedTypeReference<List<Client>> parameterizedTypeReferenceForList() {
		return parameterizedTypeReference;
	}
	
	@Override
	public List<Client> findAll(String username) {
		Assert.hasText(username);
		return getList(withUrl(userUrl, username, "clients"));
	}

	@Override
	public Optional<Client> find(String clientId){
		Assert.hasText(clientId);
		return get(withUrl(clientUrl, clientId));
	}

	@Override
	public Client update(Client client){
		Assert.notNull(client);
		return put(withUrl(clientUrl, client.getId()), client);
	}

	@Override
	public Client create(Client client){
		Assert.notNull(client);
		return post(clientUrl, client);
	}

	@Override
	public void remove(Client client) {
		Assert.notNull(client);
		delete(withUrl(clientUrl, client.getId()));
	}

	@Override
	public Client refreshSecret(String clientId) {
		Assert.hasText(clientId);
		return post(withUrl(clientUrl, clientId, "refresh_secret"));
	}

	@Override
	public List<Client> search(Client dto) {
		
		Assert.notNull(dto);
		
		String url = UriComponentsBuilder.fromHttpUrl(clientUrl)
				.queryParam("name", dto.getName())
				.queryParam("id", dto.getId())
				.queryParam("owner", dto.getOwner())
				.queryParam("deleted", dto.isDeleted())
				.build(false).toUriString();
		
		return getList(url);
	}
}