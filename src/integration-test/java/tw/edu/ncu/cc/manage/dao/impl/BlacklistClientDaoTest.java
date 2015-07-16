package tw.edu.ncu.cc.manage.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.dao.impl.utils.DaoTestUtils;
import tw.edu.ncu.cc.manage.domain.BlacklistClient;
import tw.edu.ncu.cc.manage.domain.Client;

public class BlacklistClientDaoTest {

	private ClientDao clientDao;

	private BlacklistClientDao blacklistClientDao;

	private Client client;
	
	@Before
	public void setUp() throws Exception {
		clientDao = new ClientDao();
		blacklistClientDao = new BlacklistClientDao();

		clientDao.setRootUrl(DaoTestUtils.ROOT_URL);
		blacklistClientDao.setRootUrl(DaoTestUtils.ROOT_URL);

		client = clientDao.create(DaoTestUtils.client());
	}

	@Test
	public void shouldMatchApiSpecification() {
		testCreate();
		testSearch();
		testUpdate();
		testDelete();
	}

	public void testCreate() {
		String reason = "TEST";
		BlacklistClient blacklistClient = new BlacklistClient();
		blacklistClient.setClient_id(client.getId());
		blacklistClient.setReason(reason);

		BlacklistClient createBlacklistClient = this.blacklistClientDao.create(blacklistClient);
		assertEquals(client.getId(), createBlacklistClient.getClient_id());
		assertEquals(reason, createBlacklistClient.getReason());
	}

	public void testFind() {
		this.blacklistClientDao.find(client.getId()).get();
	}
	
	public void testSearch() {
		this.blacklistClientDao.search(client).stream().findFirst().get();
	}

	public void testUpdate() {
		String anotherReason = "ANOTHER";
		BlacklistClient blacklistClient = new BlacklistClient();
		blacklistClient.setClient_id(client.getId());
		blacklistClient.setReason(anotherReason);
		
		BlacklistClient updateBlacklistClient = this.blacklistClientDao.update(blacklistClient);
		assertEquals(client.getId(), updateBlacklistClient.getClient_id());
		assertEquals(anotherReason, updateBlacklistClient.getReason());
	}
	
	public void testDelete() {
		BlacklistClient blacklistClient = new BlacklistClient();
		blacklistClient.setClient_id(client.getId());
		
		this.blacklistClientDao.remove(blacklistClient);
	}

	@After
	public void tearDown() {
		this.clientDao.remove(client);
	}
}
