package Lab8.prob4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//String[] names = {"Alexis", "Tim", "Kyleen", "Kristy"};
//b. Convert the sorted names array into List.
public class probB {
    public static void main(String[] args) {
        String[] names = {"Alexis", "Tim", "Kyleen", "Kristy"};
        Arrays.sort(names, String::compareTo);
        List<String> namesList = Arrays.stream(names).collect(Collectors.toList());
        System.out.println(namesList);
    }
}
