package tw.edu.ncu.cc.manage.dao.impl;

import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.PropertySource;

import tw.edu.ncu.cc.manage.domain.User;

@PropertySource("classpath:OAuth-service.properties")
public class UserDaoTest {

	
	private UserDao userDao;
	
	@Before
	public void setUp() throws Exception {
		userDao = new UserDao();
		userDao.setRootUrl("https://140.115.3.188/oauth/management/v1/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind() {
		Optional<User> user = userDao.find("ABCDEFG");
		if (!user.isPresent()) {
			fail("User not present.");
		}
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

}
