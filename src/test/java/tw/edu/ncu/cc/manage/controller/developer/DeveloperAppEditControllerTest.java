package tw.edu.ncu.cc.manage.controller.developer;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.domain.Client;


public class DeveloperAppEditControllerTest {

	private ClientController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new ClientController();
	}

	@Test
	public void testIsAuthorized() {
		
		String username = "fakeowner";
		
		Client client = new Client();
		client.setOwner(username);
		
		Optional<Client> mockAppOptional = Optional.of(client); 
		assertTrue(controller.isAuthorized(mockAppOptional, username));
	}

}
