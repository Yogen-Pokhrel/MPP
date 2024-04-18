package Lab8.prob4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//String[] names = {"Alexis", "Tim", "Kyleen", "Kristy"};
//a. Use Arrays.sort() to sort the names by ignore case using Method reference.
//b. Convert the sorted names array into List.
//c. Print the sorted list using method reference.
public class probA {
    public static void main(String[] args) {
        String[] names = {"Alexis", "Tim", "Kyleen", "Kristy"};
        Arrays.sort(names, String::compareTo);
        System.out.println(Arrays.toString(names));
    }
}
