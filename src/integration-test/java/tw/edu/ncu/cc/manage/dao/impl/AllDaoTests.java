package tw.edu.ncu.cc.manage.dao.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ApiTokenDaoTest.class, 
	AuthorizedTokenDaoTest.class, 
	BlacklistClientDaoTest.class, 
	BlacklistUserDaoTest.class, 
	ClientDaoTest.class,
	ManagerDaoTest.class, 
	UserDaoTest.class })
public class AllDaoTests {

}
