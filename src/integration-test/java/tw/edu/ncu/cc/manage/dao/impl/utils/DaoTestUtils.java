package tw.edu.ncu.cc.manage.dao.impl.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import tw.edu.ncu.cc.manage.domain.Client;

public class DaoTestUtils {
	public static String ROOT_URL = null;
	public static final String FAKE_USER_NAME = "VERIFY_TEST_USER_NAME";
	public static final String FAKE_NAME = "VERIFY_TEST_NAME";

	static {
		setRootUrl();
	}

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
	
	private static final void setRootUrl() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("src/integration-test/resources/OAuth-service.properties");
			prop.load(input);
			ROOT_URL = prop.getProperty("oauth.root");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
