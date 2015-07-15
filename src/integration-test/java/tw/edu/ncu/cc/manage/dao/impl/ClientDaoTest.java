package tw.edu.ncu.cc.manage.dao.impl;

import static org.junit.Assert.*;

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
		testCreate();
		testFind();
		testFindAll();
		testSearch();
		testUpdate();
		testRefreshSecret();
		testRemove();
	}
	
	private void testCreate() {
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
	}

	private void testFind() {

	}

	private void testFindAll() {

	}

	private void testSearch() {

	}

	private void testUpdate() {

	}

	private void testRefreshSecret() {

	}

	private void testRemove() {

	}

}
