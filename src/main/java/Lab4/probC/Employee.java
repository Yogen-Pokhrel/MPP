package Lab4.probC;

public abstract class Employee {
    private String empId;

    public Employee(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public void print(int month, int year) {
        System.out.println("Employee ID: " + empId + "\n" + calcCompensation(month, year));
    }

    public abstract double calcGrossPay(int month, int year);

    public PayCheck calcCompensation(int month, int year) {
        return new PayCheck(calcGrossPay(month, year), 23, 5, 1, 3, 7.5);
    };

}
