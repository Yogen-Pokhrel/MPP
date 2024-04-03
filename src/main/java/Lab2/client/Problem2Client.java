package Lab2.client;

import Lab2.Problem2b.Order;
import Lab2.Problem2b.OrderLine;

import java.time.LocalDate;

public class Problem2Client {
    public static void main(String[] args) {
        Order order = new Order( 1, LocalDate.now());
        order.addOrderLine(1, 5, 2);
        order.addOrderLine(2, 6, 3);
        System.out.println("Your grand total is:" + order.computeTotalPrice());
    }
}
