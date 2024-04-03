package Lab2.prob2B;

import Lab2.prob2B.Order;

import java.time.LocalDate;

public class OrderOrderLineFactory {
    public static Order createOrder(int num, LocalDate orderDate){
        if(orderDate == null){
            throw new Error("No order-date found");
        }
        return new Order(num, orderDate);
    }
}
