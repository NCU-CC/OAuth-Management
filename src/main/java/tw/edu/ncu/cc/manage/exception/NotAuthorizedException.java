package tw.edu.ncu.cc.manage.exception;

public class NotAuthorizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAuthorizedException(String reason) {
		super(reason);
	}
}
