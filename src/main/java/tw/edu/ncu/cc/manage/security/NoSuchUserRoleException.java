package tw.edu.ncu.cc.manage.security;

import java.util.List;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.openid.OpenIDAuthenticationToken;

/**
 * 使用者的角色不在被允許處理本系統的範圍內
 * @author yyc1217
 *
 */
public class NoSuchUserRoleException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchUserRoleException(String msg) {
		super(msg);
	}

	public NoSuchUserRoleException(OpenIDAuthenticationToken token, List<String> permitRoles) {
		this("Available roles not found:" + token + ", expected:" + permitRoles);
	}

}
