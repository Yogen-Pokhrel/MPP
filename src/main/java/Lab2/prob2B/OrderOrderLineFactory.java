package Lab2.prob2B;

import Lab2.prob2B.Order;

import java.time.LocalDate;

public class OrderOrderLineFactory {
    /**
     * Since Order and Order Line has One-to-Many Relationship we shall ask the user to provide at least one order line
    **/
    public static Order createOrder(int orderNum, LocalDate orderDate, int orderLineNum, double price, int quantity){
        if(orderDate == null){
            throw new Error("No order-date found");
        }
        Order o =  new Order(orderNum, orderDate);
        o.addOrderLine(orderLineNum, price, quantity);
        return o;
    }
}
