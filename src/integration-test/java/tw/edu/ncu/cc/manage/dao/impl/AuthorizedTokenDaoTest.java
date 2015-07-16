package tw.edu.ncu.cc.manage.dao.impl;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import tw.edu.ncu.cc.manage.domain.AuthorizedToken;



public class AuthorizedTokenDaoTest {

	private RestTemplate restTemplate;
	
	private AuthorizedTokenDao authorizedTokenDao;
	
	@Before
	public void setUp() throws Exception {
			
		this.restTemplate = new RestTemplate();
				
		authorizedTokenDao = new AuthorizedTokenDao();
		authorizedTokenDao.setRootUrl("/");
		authorizedTokenDao.setRestTemplate(this.restTemplate);
	}

	@Test
	public void test() {
		testFind();
		testFindAll();
		testRevoke();
	}

	public void testFind() {
		
		MockRestServiceServer mockServer = MockRestServiceServer.createServer(this.restTemplate);
		
		mockServer
		.expect(requestTo("/authorized_tokens/1"))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withSuccess(responseAuthorizedToken(), MediaType.APPLICATION_JSON));
		
		AuthorizedToken token = this.authorizedTokenDao.find("1").get();
		
		mockServer.verify();
		
		assertEquals("1", token.getId());
		assertEquals("jason", token.getUser());
		assertArrayEquals(new String[] {"read", "write"}, token.getScope());
		assertEquals(new Timestamp(1436262479000L), token.getLast_updated());
		assertNotNull(token.getClient());
		assertEquals("asjd1623", token.getClient().getId());
	}
	
	public void testFindAll() {
		MockRestServiceServer mockServer = MockRestServiceServer.createServer(this.restTemplate);
		
		mockServer
		.expect(requestTo("/users/FAKENAME/authorized_tokens"))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withSuccess(responseAuthorizedTokens(), MediaType.APPLICATION_JSON));
		
		List<AuthorizedToken> tokens = this.authorizedTokenDao.findAll("FAKENAME");
		
		assertThat(tokens, hasSize(1));
		
	}
	
	public void testRevoke() {
		
		MockRestServiceServer mockServer = MockRestServiceServer.createServer(this.restTemplate);
		
		mockServer
		.expect(requestTo("/authorized_tokens/1"))
		.andExpect(method(HttpMethod.DELETE))
		.andRespond(withSuccess(responseAuthorizedToken(), MediaType.APPLICATION_JSON));
		
		AuthorizedToken token = new AuthorizedToken();
		token.setId("1");
		this.authorizedTokenDao.revoke(token);
		
		mockServer.verify();
	}
	
	private String responseAuthorizedToken() {
		String responseBody = "{\"id\":\"1\",\"user\":\"jason\",\"scope\":[\"read\",\"write\"],\"last_updated\":1436262479000,\"client\":{\"id\":\"asjd1623\",\"name\":\"testapp\",\"description\":\"asentence\",\"url\":\"http://www.ncu.cc.edu.tw\",\"callback\":\"abc://gg\",\"owner\":\"jason\",\"deleted\":false}}";
		return responseBody;
	}
	
	private String responseAuthorizedTokens() {
		return "[" + responseAuthorizedToken() + "]";
	}
}
