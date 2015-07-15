package tw.edu.ncu.cc.manage.dao.impl.utils;

import tw.edu.ncu.cc.manage.domain.Client;

public class DaoTestUtils {
	public static final String ROOT_URL = "https://140.115.3.188/oauth/management/v1/";
	public static final String FAKE_USER_NAME = "VERIFY_TEST_USER_NAME";
	public static final String FAKE_NAME = "VERIFY_TEST_NAME";
	
	public static final Client client() {
		
		Client client = new Client();
		client.setName("測試app名字");
		client.setDescription("測試app描述");
		client.setUrl("http://example.com");
		client.setCallback("http://example.com/callback");
		client.setOwner(DaoTestUtils.FAKE_USER_NAME);
		client.setDeleted(false);
		
		return client;
	}
}
