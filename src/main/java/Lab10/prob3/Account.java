package Lab10.prob3;

import java.util.Objects;

public class Account {
    private final String accountNumber;
    private double balance;
    private final Customer customer;

    Account(Customer customer, String accountNumber, double balance){
        this.customer = customer;
        this.accountNumber = accountNumber.toUpperCase();
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(o.getClass() != this.getClass()){
            return false;
        }
        Account e = (Account) o;
        return e.getCustomer().equals(getCustomer()) && e.getAccountNumber().equals(getAccountNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getAccountNumber());
    }
}
