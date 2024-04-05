package Lab4.probC;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        list.add(new Order("100", LocalDate.of(2023, 2, 1), 200));
        list.add(new Order("100", LocalDate.of(2023, 2, 10), 100));
        Commissioned cm = new Commissioned("123", 0.8, 500, list);
        Employee[] emp = { new Salaried("121", 4000), new Hourly("122", 15.67, 20), cm };
        for (Employee e : emp) {
            e.print(3, 2023);
            System.out.println();
        }
    }
}
