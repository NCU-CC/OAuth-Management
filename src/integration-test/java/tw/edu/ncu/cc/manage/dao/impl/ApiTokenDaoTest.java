package tw.edu.ncu.cc.manage.dao.impl;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.dao.impl.utils.DaoTestUtils;
import tw.edu.ncu.cc.manage.domain.ApiToken;
import tw.edu.ncu.cc.manage.domain.Client;

public class ApiTokenDaoTest {

	private ApiTokenDao apiTokenDao;

	private ApiToken apiToken;
	
	private ClientDao clientDao;
	
	private Client client;
		
	@Before
	public void setUp() throws Exception {
		apiTokenDao = new ApiTokenDao();
		apiTokenDao.setRootUrl(DaoTestUtils.ROOT_URL);
		
		clientDao = new ClientDao();
		clientDao.setRootUrl(DaoTestUtils.ROOT_URL);
		client = this.clientDao.create(DaoTestUtils.client());
	}

	@Test
	public void shouldMatchApiSpecification() {
		testCreate();
		testFindByClient();
		testFindByToken();
		testRefresh();
		testRemove();
	}

	public void testCreate() {
		apiToken = this.apiTokenDao.create(client.getId());
		
		assertThat(apiToken.getId(), not(isEmptyOrNullString()));
		assertThat(apiToken.getToken(), not(isEmptyOrNullString()));
		assertEquals(apiToken.getClient_id(), client.getId());
	}

	public void testFindByClient() {
		ApiToken findApiToken = this.apiTokenDao.findByClient(client.getId()).stream().findFirst().get();
		
		assertEquals(this.apiToken.getId(), findApiToken.getId());
		assertEquals(this.apiToken.getToken(), findApiToken.getToken());
		assertEquals(this.apiToken.getClient_id(), findApiToken.getClient_id());
	}

	public void testFindByToken() {
		ApiToken findByToken = this.apiTokenDao.find(this.apiToken.getId()).get();
		
		assertEquals(this.apiToken.getId(), findByToken.getId());
		assertEquals(this.apiToken.getToken(), findByToken.getToken());
		assertEquals(this.apiToken.getClient_id(), findByToken.getClient_id());		
	}

	public void testRefresh() {
		ApiToken refreshApiToken = this.apiTokenDao.refresh(this.apiToken.getId());

		assertEquals(this.apiToken.getId(), refreshApiToken.getId());
		assertNotEquals(this.apiToken.getToken(), refreshApiToken.getToken());
		assertEquals(this.apiToken.getClient_id(), refreshApiToken.getClient_id());
	}

	public void testRemove() {
		this.apiTokenDao.revoke(apiToken);
	}
	
	@After
	public void tearDown() {
		this.clientDao.remove(client);
	}
}