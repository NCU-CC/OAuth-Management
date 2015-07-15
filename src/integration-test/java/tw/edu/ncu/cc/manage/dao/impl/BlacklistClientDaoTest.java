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

	private BlacklistClient testBlacklistClient;
	
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
		testDelete();
	}

	public void testCreate() {
		BlacklistClient blacklistClient = new BlacklistClient();
		blacklistClient.setClient_id(client.getId());
		blacklistClient.setReason("TEST");

		testBlacklistClient = this.blacklistClientDao.create(blacklistClient);
		assertEquals(blacklistClient.getClient_id(), testBlacklistClient.getClient_id());
		assertEquals(blacklistClient.getReason(), testBlacklistClient.getReason());
	}

	public void testSearch() {
		this.blacklistClientDao.search(client).stream().findFirst().get();
	}

	public void testDelete() {
		this.blacklistClientDao.delete(testBlacklistClient);
	}

	@After
	public void tearDown() {
		this.clientDao.remove(client);
	}
}
