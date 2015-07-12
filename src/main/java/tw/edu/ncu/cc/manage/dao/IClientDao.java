package tw.edu.ncu.cc.manage.dao;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.Client;

public interface IClientDao {

	List<Client> findAll(String username);

	Optional<Client> find(String clientId);

	Client update(Client client);

	Client refreshSecret(String clientId);

	void remove(Client client);

	Client create(Client client);

	List<Client> search(Client dto);

}
