package Lab8.prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductInfo {


    static enum SortMethod {BYPRICE, BYTITLE};
    SortMethod method;

    public void sort(List<Product> emps) {
        if(method == SortMethod.BYPRICE) {
            Collections.sort(emps, new ProductPriceComparator());
        }
        else if(method == SortMethod.BYTITLE) {
            Collections.sort(emps, new ProductTitleComparator());
        }
    }

    public static void main(String[] args) {
        List<Product> emps = new ArrayList<>();
            emps.add(new Product("Laptop", 1900.0, 1));
            emps.add(new Product("Phone", 1600.0, 2));
            emps.add(new Product("Car", 2000.0, 3));

            Collections.sort(emps, new ProductTitleComparator());
            System.out.println("Sort Product By Title");
            System.out.println(emps);

            Collections.sort(emps, new ProductPriceComparator());
            System.out.println("Sort Product By Price");
            System.out.println(emps);

        }

}
