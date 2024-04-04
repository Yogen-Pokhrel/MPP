package Lab2.prob2B;

import Lab2.prob2B.Order;

import java.time.LocalDate;

public class OrderOrderLineFactory {
    public static Order createOrder(int num, LocalDate orderDate, int orderLineNum, double price, int quantity){
        if(orderDate == null){
            throw new Error("No order-date found");
        }
        Order o =  new Order(num, orderDate);
        o.addOrderLine(orderLineNum, price, quantity);
        return o;
    }
}
