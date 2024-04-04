package Lab2.client;

import Lab2.prob2B.Order;
import Lab2.prob2B.OrderOrderLineFactory;

import java.time.LocalDate;

public class Problem2Client {
    public static void main(String[] args) {
        Order order =  OrderOrderLineFactory.createOrder(1, LocalDate.now(), 4,100, 7);
        order.addOrderLine(1, 5, 2);
        order.addOrderLine(2, 6, 3);
        System.out.println("Your grand total is:" + order.computeTotalPrice());
    }
}
