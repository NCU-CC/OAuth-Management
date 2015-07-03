package tw.edu.ncu.cc.manage.controller.developer;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.domain.Client;
import tw.edu.ncu.cc.manage.exception.NotAuthorizedException;


public class DeveloperAppEditControllerTest {

	private ClientController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new ClientController();
	}

	@Test
	public void testIsAuthorized() throws NotAuthorizedException {
		
		String username = "fakeowner";
		
		Client client = new Client();
		client.setOwner(username);
		
		Optional<Client> mockAppOptional = Optional.of(client); 
		controller.validateClient(mockAppOptional, username);
	}

}
