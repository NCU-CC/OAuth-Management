package tw.edu.ncu.cc.manage.dao.impl;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.dao.impl.utils.DaoTestUtils;
import tw.edu.ncu.cc.manage.domain.Manager;

public class ManagerDaoTest {

	private ManagerDao managerDao;
	
	@Before
	public void setUp() throws Exception {
		managerDao = new ManagerDao();
		managerDao.setRootUrl(DaoTestUtils.ROOT_URL);
	}

	@Test
	public void shouldMatchApiSpecification() {
		testCreate();
		testFind();
		testFindAll();
		testDelete();
	}
	
	private Manager manager() {
		Manager manager = new Manager();
		manager.setId(DaoTestUtils.FAKE_USER_NAME);
		manager.setName(DaoTestUtils.FAKE_NAME);
		return manager;
	}
	
	private void testCreate() {
		Manager manager = manager();
		Manager createManager = this.managerDao.create(manager);
		assertEquals(manager.getId(), createManager.getId());		
	}
	
	private void testFind() {
		Optional<Manager> findManager = this.managerDao.find(DaoTestUtils.FAKE_USER_NAME);
		assertTrue(findManager.isPresent());
	}
	
	private void testFindAll() {
		Optional<Manager> findAllManager = this.managerDao.findAll().stream().findAny();
		assertTrue(findAllManager.isPresent());
	}
	
	private void testDelete() {
		this.managerDao.delete(manager());
	}
}
