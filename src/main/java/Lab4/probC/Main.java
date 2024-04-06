package Lab4.probC;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        list.add(new Order("100", LocalDate.of(2023, 2, 1), 2000));
        list.add(new Order("101", LocalDate.of(2023, 2, 10), 1000));
        list.add(new Order("102", LocalDate.of(2023, 2, 12), 12000));
        Commissioned cm = new Commissioned("123", 0.8, 500, list);
        Employee[] emp = { new Salaried("121", 7000), new Hourly("122", 15.67, 20), cm };
        for (Employee e : emp) {
            e.print(3, 2023);
            System.out.println();
        }
    }
}
