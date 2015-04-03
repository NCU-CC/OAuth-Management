package tw.edu.ncu.cc.manage.security;

import org.springframework.security.core.AuthenticationException;

/**
 * 使用者的角色不在被允許處理本系統的範圍內
 * @author Yeh-Yung
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

}
