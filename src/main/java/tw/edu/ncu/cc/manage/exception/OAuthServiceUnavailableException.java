package tw.edu.ncu.cc.manage.exception;

import java.io.IOException;

/**
 * 遠端的服務無法使用
 * @author yyc1217
 *
 */
public class OAuthServiceUnavailableException extends IOException {

	private static final long serialVersionUID = 1L;

	public OAuthServiceUnavailableException(String message) {
		super(message);
	}
	
	public OAuthServiceUnavailableException(Throwable e) {
		super(e);
	}
	
}