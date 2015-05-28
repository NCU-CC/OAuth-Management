package tw.edu.ncu.cc.manage.service;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.Client;

public interface IClientService {

	List<Client> findAll(String username);

	Optional<Client> find(String id);

	Client update(Client client);

	void remove(Client client);

	Client refreshSecret(String id);

	Client create(Client client);

}
