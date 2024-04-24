package Lab10.prob3;

import java.util.Objects;

public class Employee {
    private String fName;
    private String lName;
    private double salary;

    Employee(String firstName, String lastName, double sal){
        fName = firstName;
        lName = lastName;
        salary = sal;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(o.getClass() != this.getClass()){
            return false;
        }
        Employee e = (Employee) o;
        return e.getfName().equals(getfName()) && e.getlName().equals(getlName()) && e.getSalary() == getSalary();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getfName(), getlName(), getSalary());
    }
}
