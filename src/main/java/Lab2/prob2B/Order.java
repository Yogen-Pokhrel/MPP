package Lab2.prob2B;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    int orderNum;
    LocalDate orderDate;
    List<OrderLine> orderLines;

    Order(int orderNum, LocalDate orderDate) {
        this.orderNum = orderNum;
        this.orderDate = orderDate;
        orderLines = new ArrayList<>();
    }

    public int getOrderNum() {
        return orderNum;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double computeTotalPrice(){
        double price = 0.0;
        for(OrderLine orderLine : orderLines){
            price += orderLine.computeTotal();
        }
        return price;
    }

    public void addOrderLine(int orderLineNum, double price, int quantity){
        orderLines.add(new OrderLine( orderLineNum,  price,  quantity, this));
    }

    public List<OrderLine> getOrderLines(){
        return orderLines;
    }
}
