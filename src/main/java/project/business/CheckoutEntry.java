package project.business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {
    private static final long serialVersionUID = 611069276685962829L;

    //can be removed as bookCopy has two-way association
    private final Book book;

    private final BookCopy bookCopy;
    private final LocalDate checkoutDate;
    private LocalDate dueDate;

    private LocalDate lastRenewedDate;

    public CheckoutEntry(Book book, BookCopy bookCopy){
        this.bookCopy = book.getNextAvailableCopy();
        this.book = book;
        bookCopy.changeAvailability();
        checkoutDate = LocalDate.now();
        dueDate = checkoutDate.plusDays(book.getMaxCheckoutLength());
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public Book getBook() {
        return book;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //used if renewable of book is allowed
    public void renew(){
        lastRenewedDate = LocalDate.now();
        dueDate = lastRenewedDate.plusDays(book.getMaxCheckoutLength());
    }

    public LocalDate getLastRenewedDate() {
        return lastRenewedDate;
    }
}
