package project.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import project.dataaccess.Auth;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;
import project.dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = Auth.LIBRARIAN;
	public static User loggedInUser = null;
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		loggedInUser = map.get(id);
		currentAuth = loggedInUser.getAuthorization();
		
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}

	public HashMap<String, Book> getAllBooks() {
		DataAccess da = new DataAccessFacade();
		return da.readBooksMap();
	}

	public HashMap<String, Author> getAllAuthors() {
		DataAccess da = new DataAccessFacade();
		return da.readAuthorMap();
	}

	public HashMap<String, LibraryMember> getAllLibraryMembers() {
		DataAccess da = new DataAccessFacade();
		return da.readMemberMap();
	}
	
	
}
