package Lab8.prob2.prob2c;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import Lab8.prob2.Product;

public class Problem2c {
    static enum SortMethod {
        BYPRICE, BYTITLE
    };

    public static void sort(List<Product> products, final SortMethod method) {
        class ProductComparator implements Comparator<Product> {
            @Override
            public int compare(Product p1, Product p2) {
                if (method == SortMethod.BYPRICE) {
                    return Double.compare(p1.getPrice(), p2.getPrice());
                } else {
                    return p1.getTitle().compareTo(p2.getTitle());
                }
            }
        }

        products.sort(new ProductComparator());
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Product A", 10.0, 1),
                new Product("Product B", 5.0, 2),
                new Product("Product C", 15.0, 3));

        sort(products, SortMethod.BYPRICE);
        printProducts(products);
        System.out.println();
        System.out.println();
        sort(products, SortMethod.BYTITLE);
        printProducts(products);
    }

    private static void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}