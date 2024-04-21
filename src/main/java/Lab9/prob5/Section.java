
package Lab9.prob5;

import java.util.Arrays;
import java.util.stream.Stream;

public class Section {
    public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
        return stream.skip(m).limit(n-m+1);
    }

    public static void main(String[] args) {
        Stream<String> s1 = streamSection(nextStream(),0,3 );
        System.out.println("From 0 to 3");
        s1.forEach(System.out::println);

        Stream<String> s2 = streamSection(nextStream(),2,5 );
        System.out.println("\nFrom 2 to 5");
        s2.forEach(System.out::println);

        Stream<String> s3 = streamSection(nextStream(),1,4 );
        System.out.println("\nFrom 1 to 4");
        s3.forEach(System.out::println);
    }

    private static Stream<String> nextStream() {
        return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh",
                "iii").stream();
    }
}
