package project.business;

import java.time.LocalDate;

public class CheckoutEntry {
    private final Book book;
    private final LocalDate checkoutDate;
    private LocalDate dueDate;

    private LocalDate lastRenewedDate;

    public CheckoutEntry(Book book){
        BookCopy copy = book.getNextAvailableCopy();
        if(copy != null){
            copy.changeAvailability();
        }
        this.book = book;
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
