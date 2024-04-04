package Lab2.client;

import Lab2.prob2B.Order;
import Lab2.prob2B.OrderLine;
import Lab2.prob2B.OrderOrderLineFactory;

import java.time.LocalDate;
import java.util.List;

public class Prob2BClient {
    public static void main(String[] args) {
        Order order =  OrderOrderLineFactory.createOrder(1, LocalDate.now(), 4,100, 7);
        order.addOrderLine(1, 5, 2);
        order.addOrderLine(2, 6, 3);

        List<OrderLine> lineItems = order.getOrderLines();
        for (OrderLine ol: lineItems){
            System.out.println(ol);
        }

        System.out.println("Your grand total is: " + order.computeTotalPrice());
    }
}
