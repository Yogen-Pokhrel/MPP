package project.business;

public class LoginException extends Exception {

	public LoginException() {
		super();
	}

	public LoginException(String msg) {
		super(msg);
	}

	public LoginException(Throwable t) {
		super(t);
	}

	private static final long serialVersionUID = 8978723266036027364L;

}
