package tw.edu.ncu.cc.manage.controller.developer;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.entity.oauth.Application;


public class DeveloperAppEditControllerTest {

	private DeveloperAppEditController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new DeveloperAppEditController();
	}

	@Test
	public void testIsAuthorized() {
		
		String username = "fakeowner";
		
		Application app = new Application();
		app.setOwner(username);
		
		Optional<Application> mockAppOptional = Optional.of(app); 
		assertTrue(controller.isAuthorized(mockAppOptional, username));
	}

}
