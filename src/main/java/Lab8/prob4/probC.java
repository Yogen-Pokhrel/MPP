package Lab8.prob4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//String[] names = {"Alexis", "Tim", "Kyleen", "Kristy"};
//c. Print the sorted list using method reference.
public class probC {
    public static void main(String[] args) {
        String[] names = {"Alexis", "Tim", "Kyleen", "Kristy"};
        Arrays.sort(names, String::compareTo);
        List<String> namesList = Arrays.stream(names).collect(Collectors.toList());
        namesList.forEach(System.out::println);
    }
}