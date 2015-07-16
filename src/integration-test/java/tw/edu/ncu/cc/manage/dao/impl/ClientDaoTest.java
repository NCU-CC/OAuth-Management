package tw.edu.ncu.cc.manage.dao.impl;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.dao.impl.utils.DaoTestUtils;
import tw.edu.ncu.cc.manage.domain.Client;

public class ClientDaoTest {

	private ClientDao clientDao;
	
	private Client createClient;
	
	private Client updateClient;
	
	
	@Before
	public void setUp() throws Exception {
		clientDao = new ClientDao();
		clientDao.setRootUrl(DaoTestUtils.ROOT_URL);
	}

	@Test
	public void shouldMatchApiSpecification() {
		testCreate();
		testFindByClientId();
		testFindAllByUsername();
		testSearch();
		testUpdate();
		testRefreshSecret();
		testRemove();
	}
	
	private Client testCreate() {
		Client client = DaoTestUtils.client();
		createClient = this.clientDao.create(client);
		
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

	private void testFindByClientId() {
		Optional<Client> findClient = this.clientDao.find(createClient.getId());
		findClient.get();
	}

	private void testFindAllByUsername() {
		List<Client> clients = this.clientDao.findAll(createClient.getOwner());
		assertThat(clients, hasSize(greaterThan(0)));
	}

	private void testSearch() {
		Client client = createClient;
		Client dto = new Client();
		
		dto.setName(client.getName());
		dto.setId(client.getId());
		dto.setOwner(client.getOwner());
		dto.setDeleted(client.isDeleted());
		
		List<Client> clients = this.clientDao.search(dto);
		assertThat(clients, hasSize(greaterThan(0)));
	}

	private void testUpdate() {
		Client client = createClient;
		String dummy = "ttt";
		
		client.setName(client.getName().concat(dummy));
		client.setDescription(client.getDescription().concat(dummy));
		client.setUrl(client.getUrl().concat(dummy));
		client.setCallback(client.getCallback().concat(dummy));
		
		updateClient = this.clientDao.update(client);
		assertEquals(client.getName(), updateClient.getName());
		assertEquals(client.getDescription(), updateClient.getDescription());
		assertEquals(client.getUrl(), updateClient.getUrl());
		assertEquals(client.getCallback(), updateClient.getCallback());
	}

	private void testRefreshSecret() {
		Client client = updateClient;
		String originSecret = new String(client.getSecret());
		
		Client refreshClient = this.clientDao.refreshSecret(client.getId());
		assertNotEquals(originSecret, refreshClient.getSecret());
	}

	private void testRemove() {
		Client client = updateClient;
				
		this.clientDao.remove(client);
		client.setDeleted(true);
		
		Client findClient = this.clientDao.search(client).stream().findAny().get();
		assertTrue(findClient.isDeleted());
	}

}
