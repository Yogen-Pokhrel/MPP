package Lab2.Problem2b;

public class OrderLine {
    int orderLineNum;
    double price;
    int quantity;

    OrderLine(int orderLineNum, double price, int quantity){
        this.orderLineNum = orderLineNum;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderLineNum() {
        return orderLineNum;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double computeTotal(){
        return price * quantity;
    }

    public void setOrderLineNum(int orderLineNum) {
        this.orderLineNum = orderLineNum;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
