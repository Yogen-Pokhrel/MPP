package Lab4.probC;

import java.time.LocalDate;
import java.util.List;

public class Commissioned extends Employee {
    private double commission;
    private double baseSalary;
    private List<Order> orders;

    public Commissioned(String empId, double commission, double baseSalary, List<Order> orders) {
        super(empId);
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double total = 0;
        List<Order> orders= getOrders();
        month = month - 1;
        if(month <= 0){
            month = 11;
            year--;
        }
        for (Order order : orders) {
            LocalDate orderDate = order.getOrderDate();
            if (orderDate.getMonthValue() == month && orderDate.getYear() == year) {
                total += order.getOrderAmount();
            }
        }
        return (total * commission / 100) + baseSalary;
    }
}
