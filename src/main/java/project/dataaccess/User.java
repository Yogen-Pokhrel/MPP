package project.dataaccess;

import project.business.Person;

final public class User extends Person {

	private static final long serialVersionUID = 5147265048973262104L;

	private String id;

	private String password;
	private Auth authorization;

	User(String id, String pass, Auth auth, String fName, String lName, String phone) {
		super(fName, lName, phone);
		this.id = id;
		this.password = pass;
		this.authorization = auth;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Auth getAuthorization() {
		return authorization;
	}

	@Override
	public String toString() {
		return "[" + id + ":" + password + ", " + authorization.toString() + "]";
	}

}
