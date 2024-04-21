package Lab9.prob7b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {

    public static final TriFunction<List<Employee>, Integer, String , List<String>> SALARY_NAME_CHECK = (list, salary, searchStr) ->
            list.stream()
                    .filter(x -> x.getSalary()>100000)
                    .filter(x -> x.getLastName().compareTo("M") > 0)
                    .map(x -> x.getFirstName() + " " + x.getLastName())
                    .sorted()
                    .collect(Collectors.toList());
}
