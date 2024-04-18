package Lab9.prob4;

import java.util.stream.IntStream;

public class Main {

    public static void printSquares(int num) {
        IntStream.iterate(1, n -> n + 1).map(n -> n * n).limit(num).forEach(System.out::println);
    }

    public static void main(String[] args) {
        printSquares(4);
    }
}
