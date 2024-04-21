package Lab9.prob6;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Set<String> union(List<Set<String>> sets){
        //this prints [A, 1, B, 3, D, 5]
        //return sets.stream().flatMap(Set::stream).collect(Collectors.toSet());

        //this prints [A, B, D, 1, 3, 5]
        return sets.stream().flatMap(Set::stream).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void main(String[] args) {
        List<Set<String>> sets = new ArrayList<>() {{
            add(new HashSet<>(Arrays.asList("A", "B")));
            add(new HashSet<>(List.of("D")));
            add(new HashSet<>(Arrays.asList("1", "3", "5")));
        }};

        Set<String> grouped = union(sets);
        System.out.println(grouped);
    }
}
