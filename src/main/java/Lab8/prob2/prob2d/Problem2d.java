package Lab8.prob2.prob2d;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import Lab8.prob2.Product;

public class Problem2d {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Product A", 10.0, 1),
                new Product("Product B", 5.0, 2),
                new Product("Product C", 15.0, 3),
                new Product("Product A", 12.0, 4) // Same title as "Product A"
        );

        Comparator<Product> comparator = (p1, p2) -> {
            int titleComparison = p1.getTitle().compareTo(p2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            } else {
                return Integer.compare(p1.getModel(), p2.getModel());
            }
        };

        products.sort(comparator);

        for (Product product : products) {
            System.out.println(product);
        }
    }
}