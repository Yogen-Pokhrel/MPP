package project.business;

import java.io.Serializable;
import java.util.Random;

final public class Author extends Person implements Serializable {
	private String bio;
	private String authorId;
	private boolean credentials;
	public String getBio() {
		return bio;
	}
	
	public Author(String f, String l, String t, Address a, String bio, boolean credentials) {
		super(f, l, t, a);
		this.bio = bio;
		this.authorId = ("A-" + java.lang.System.currentTimeMillis());
	}

	public String getAuthorId() {
		return authorId;
	}

	public boolean getCredentials() {
		return credentials;
	}

	private static final long serialVersionUID = 7508481940058530471L;
}
