package project.dataaccess;

import java.util.HashMap;

import project.business.Author;
import project.business.Book;
import project.business.CheckoutRecord;
import project.business.LibraryMember;

public interface DataAccess {
	public HashMap<String, Book> readBooksMap();

	public HashMap<String, User> readUserMap();

	public HashMap<String, LibraryMember> readMemberMap();

	public HashMap<String, Author> readAuthorMap();

	public HashMap<String, CheckoutRecord> readCheckoutRecordMap();

	public void saveNewMember(LibraryMember member);

	public void saveNewAuthor(Author author);

	public void saveNewBook(Book author);

	public void saveNewCheckoutRecord(CheckoutRecord checkoutRecord);

}
