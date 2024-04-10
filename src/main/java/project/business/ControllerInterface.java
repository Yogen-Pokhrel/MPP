package project.business;

import java.util.List;

import project.business.Book;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	
}
