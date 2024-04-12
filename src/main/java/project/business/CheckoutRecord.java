package project.business;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
    private final LibraryMember libraryMember;
    private final List<CheckoutEntry> checkoutEntries = new ArrayList<>();

    CheckoutRecord(LibraryMember libraryMember, CheckoutEntry checkoutEntry){
        this.libraryMember = libraryMember;
        this.checkoutEntries.add(checkoutEntry);
    }

    public List<CheckoutEntry> getCheckoutEntry() {
        return checkoutEntries;
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

}
