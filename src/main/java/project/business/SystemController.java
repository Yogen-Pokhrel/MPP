package project.business;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import project.dataaccess.Auth;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;
import project.dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
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

	public LibraryMember getMemberByID(String memberId) throws NullPointerException{
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> allMembers = da.readMemberMap();
		LibraryMember member = allMembers.get(memberId);
		if(member == null){
			throw new NullPointerException("No member found with provided id");
		}
		return member;
	}

	public Book getBookByISBN(String isbn) throws NullPointerException{
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> allMembers = da.readBooksMap();
		Book book = allMembers.get(isbn);
		if(book == null){
			throw new NullPointerException("No book found with provided ISBN");
		}
		return book;
	}

	public CheckoutRecord getCheckoutRecordByMemberId(String memberId){
		DataAccess da = new DataAccessFacade();
		HashMap<String, CheckoutRecord> allCheckoutRecords = da.readCheckoutRecordMap();
		return allCheckoutRecords.get(memberId);
	}

	public void addNewBook(Book book){
		DataAccess da = new DataAccessFacade();
		da.saveNewBook(book);
	}

	public void addNewMember(LibraryMember member){
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(member);
	}

	public void addNewAuthor(Author author){
		DataAccess da = new DataAccessFacade();
		da.saveNewAuthor(author);
	}

	public void addNewCheckoutRecord(CheckoutRecord checkoutRecord){
		DataAccess da = new DataAccessFacade();
		da.saveNewCheckoutRecord(checkoutRecord);
	}

}
