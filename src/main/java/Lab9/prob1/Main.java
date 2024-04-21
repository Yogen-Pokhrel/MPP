package Lab9.prob1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
        String concatenated = stringStream.collect(Collectors.joining(", "));
        System.out.println(concatenated);
    }
}
