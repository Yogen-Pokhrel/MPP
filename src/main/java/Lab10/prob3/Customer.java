package Lab10.prob3;

import java.util.Objects;

public class Customer {
    private String fName;
    private String lName;

    Customer(String firstName, String lastName){
        fName = firstName;
        lName = lastName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(o.getClass() != this.getClass()){
            return false;
        }
        Customer e = (Customer) o;
        return e.getfName().equals(getfName()) && e.getlName().equals(getlName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getfName(), getlName());
    }
}
