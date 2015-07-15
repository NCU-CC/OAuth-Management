package tw.edu.ncu.cc.manage.dao.impl;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.domain.Client;

public class ClientDaoTest {

	private ClientDao clientDao;
	
	@Before
	public void setUp() throws Exception {
		clientDao = new ClientDao();
		clientDao.setRootUrl(DaoTestUtils.ROOT_URL);
	}

	@Test
	public void shouldMatchApiSpecification() {
		Client createClient = testCreate();
		testFindByClientId(createClient.getId());
		testFindAllByUsername(createClient.getOwner());
		testSearch(createClient);
		Client updateClient = testUpdate(createClient);
		testRefreshSecret(updateClient);
		testRemove(updateClient);
	}
	
	private Client testCreate() {
		Client client = new Client();
		client.setName("測試app名字");
		client.setDescription("測試app描述");
		client.setUrl("http://example.com");
		client.setCallback("http://example.com/callback");
		client.setOwner(DaoTestUtils.FAKE_USER_NAME);
		client.setDeleted(false);
		
		Client createClient = this.clientDao.create(client);
		
		assertEquals(client.getName(), createClient.getName());
		assertEquals(client.getDescription(), createClient.getDescription());
		assertEquals(client.getUrl(), createClient.getUrl());
		assertEquals(client.getCallback(), createClient.getCallback());
		assertEquals(client.getOwner(), createClient.getOwner());
		assertEquals(client.isDeleted(), createClient.isDeleted());
		
		assertNotNull(createClient.getId());
		assertNotNull(createClient.getSecret());
		
		return createClient;
	}

	private void testFindByClientId(String clientId) {
		Optional<Client> findClient = this.clientDao.find(clientId);
		findClient.get();
	}

	private void testFindAllByUsername(String username) {
		List<Client> clients = this.clientDao.findAll(username);
		assertThat(clients, hasSize(greaterThan(0)));
	}

	private void testSearch(Client client) {
		Client dto = new Client();
		dto.setName(client.getName());
		dto.setId(client.getId());
		dto.setOwner(client.getOwner());
		dto.setDeleted(client.isDeleted());
		
		List<Client> clients = this.clientDao.search(dto);
		assertThat(clients, hasSize(greaterThan(0)));
	}

	private Client testUpdate(Client client) {
		String dummy = "ttt";
		client.setName(client.getName().concat(dummy));
		client.setDescription(client.getDescription().concat(dummy));
		client.setUrl(client.getUrl().concat(dummy));
		client.setCallback(client.getCallback().concat(dummy));
		
		Client updateClient = this.clientDao.update(client);
		assertEquals(client.getName(), updateClient.getName());
		assertEquals(client.getDescription(), updateClient.getDescription());
		assertEquals(client.getUrl(), updateClient.getUrl());
		assertEquals(client.getCallback(), updateClient.getCallback());
		
		return updateClient;
	}

	private void testRefreshSecret(Client client) {
		String originSecret = new String(client.getSecret());
		
		Client refreshClient = this.clientDao.refreshSecret(client.getId());
		assertNotEquals(originSecret, refreshClient.getSecret());
	}

	private void testRemove(Client client) {
		
		this.clientDao.remove(client);
		client.setDeleted(true);
		
		Client findClient = this.clientDao.search(client).stream().findAny().get();
		assertTrue(findClient.isDeleted());
	}

}
