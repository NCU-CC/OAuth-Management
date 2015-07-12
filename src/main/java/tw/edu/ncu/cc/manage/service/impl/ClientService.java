package tw.edu.ncu.cc.manage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IClientDao;
import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.service.IClientService;

@Service
public class ClientService implements IClientService {

	@Autowired
	private IClientDao clientDao;
	
	@Override
	public List<Client> findAll(String username) {
		return this.clientDao.findAll(username);
	}

	@Override
	public Optional<Client> find(String id) {
		return this.clientDao.find(id);
	}

	@Override
	public Client update(Client client) {
		return this.clientDao.update(client);
	}

	@Override
	public void remove(Client client) {
		this.clientDao.remove(client);		
	}

	@Override
	public Client refreshSecret(String id) {
		return this.clientDao.refreshSecret(id);
	}

	@Override
	public Client create(Client client) {
		return this.clientDao.create(client);
	}

	@Override
	public List<Client> search(Client dto) {
		return this.clientDao.search(dto);
	}
}