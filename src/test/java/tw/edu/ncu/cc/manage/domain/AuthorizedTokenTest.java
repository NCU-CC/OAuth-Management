package tw.edu.ncu.cc.manage.domain;

import static org.junit.Assert.*;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

public class AuthorizedTokenTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetScope() {

		String[] scopes = new String[] { "user.info.basic.read", "user.info.basic.write" };

		AuthorizedToken token = new AuthorizedToken();
		token.setScope(scopes);

		String[] expectedScopes = new String[] { "USER.INFO.BASIC.READ", "USER.INFO.BASIC.WRITE" };

		assertArrayEquals(expectedScopes, token.getScope());
	}

	@Test
	public void testSetScope_null() {

		AuthorizedToken token = new AuthorizedToken();
		token.setScope(null);

		String[] expectedScopes = ArrayUtils.EMPTY_STRING_ARRAY;

		assertArrayEquals(expectedScopes, token.getScope());
	}

}
