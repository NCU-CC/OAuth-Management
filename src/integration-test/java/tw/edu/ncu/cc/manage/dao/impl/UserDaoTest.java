package tw.edu.ncu.cc.manage.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.domain.User;

public class UserDaoTest {

	private static final String fakeUserName = DaoTestUtils.FAKE_USER_NAME;
	
	private UserDao userDao;
	
	@Before
	public void setUp() throws Exception {
		userDao = new UserDao();
		userDao.setRootUrl(DaoTestUtils.ROOT_URL);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldMatchApiSpecification() {
		testCreate();
		testFind();
		testSearch();
	}
	
	private void testCreate() {
		User fake = new User(fakeUserName, Collections.emptyList());
		User result = this.userDao.create(fake);
		assertEquals(result.getName(), fakeUserName);
	}
	
	private void testFind() {
		Optional<User> findUser = this.userDao.find(fakeUserName);
		assertTrue(findUser.isPresent());
	}
	
	private void testSearch() {
		Optional<User> searchUser = this.userDao.search(new User(fakeUserName, Collections.emptyList())).stream().findAny();
		assertTrue(searchUser.isPresent());
	}
}
