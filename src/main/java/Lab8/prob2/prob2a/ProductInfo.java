package Lab8.prob2.prob2a;

import Lab8.prob2.Product;
import Lab8.prob2.prob2a.ProductPriceComparator;
import Lab8.prob2.prob2b.ProductTitleComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductInfo {
    public static void main(String[] args) {
        List<Product> emps = new ArrayList<>();
            emps.add(new Product("Laptop", 1900.0, 1));
            emps.add(new Product("Phone", 1600.0, 2));
            emps.add(new Product("Car", 2000.0, 3));

            Collections.sort(emps, new ProductPriceComparator());
            System.out.println("Sort Product By Price");
            System.out.println(emps);
        }
}
