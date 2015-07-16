package tw.edu.ncu.cc.manage.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tw.edu.ncu.cc.manage.dao.impl.utils.DaoTestUtils;
import tw.edu.ncu.cc.manage.domain.BlacklistUser;

public class BlacklistUserDaoTest {

	private BlacklistUserDao blacklistUserDao;

	@Before
	public void setUp() throws Exception {
		blacklistUserDao = new BlacklistUserDao();
		blacklistUserDao.setRootUrl(DaoTestUtils.ROOT_URL);
	}

	@Test
	public void test() {
		testCreate();
		testFind();
		testSearch();
		testUpdate();
		testRemove();
	}

	private void testCreate() {
		String reason = "TEST";
		BlacklistUser blacklistUser = new BlacklistUser();
		blacklistUser.setUsername(DaoTestUtils.FAKE_USER_NAME);
		blacklistUser.setReason(reason);

		BlacklistUser createBlacklistUser = this.blacklistUserDao.create(blacklistUser);
		assertEquals(DaoTestUtils.FAKE_USER_NAME, createBlacklistUser.getUsername());
		assertEquals(reason, createBlacklistUser.getReason());
	}

	private void testFind() {
		this.blacklistUserDao.find(DaoTestUtils.FAKE_USER_NAME).get();
	}

	private void testSearch() {
		BlacklistUser dto = new BlacklistUser();
		dto.setUsername(DaoTestUtils.FAKE_USER_NAME);

		this.blacklistUserDao.search(dto).stream().findFirst().get();
	}

	private void testUpdate() {
		String anotherReason = "ANOTHER";
		BlacklistUser blacklistUser = new BlacklistUser();
		blacklistUser.setUsername(DaoTestUtils.FAKE_USER_NAME);
		blacklistUser.setReason(anotherReason);
		
		BlacklistUser updateBlacklistUser = this.blacklistUserDao.update(blacklistUser);
		assertEquals(anotherReason, updateBlacklistUser.getReason());
	}

	private void testRemove() {
		BlacklistUser blacklistUser = new BlacklistUser();
		blacklistUser.setUsername(DaoTestUtils.FAKE_USER_NAME);
		
		this.blacklistUserDao.remove(blacklistUser);
	}
}
