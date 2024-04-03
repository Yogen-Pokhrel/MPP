package Lab2.prob2B.factory;

import Lab2.prob2B.Order;

import java.time.LocalDate;

public class OrderOrderLineFactory {
    public static Order createOrder(int num, LocalDate orderDate){
        if(orderDate == null){
            throw new Error("No order-date found");
        }
        Order o1 = new Order(num, orderDate);
        return o1;
    }
}
