package project.dataaccess;

import java.util.HashMap;

import project.business.Author;
import project.business.Book;
import project.business.LibraryMember;
import project.dataaccess.DataAccessFacade.StorageType;

public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public HashMap<String, Author> readAuthorMap();
	public void saveNewMember(LibraryMember member);
	public void saveNewAuthor(Author author);
}
