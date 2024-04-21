package Lab9.prob7b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {

    public static final TriFunction<List<Employee>, Integer, Character , String> SALARY_NAME_CHECK = (list, minimumSalary, employeeSurNameAfterCharacter) ->
            list.stream()
                    .filter(x -> x.getSalary()>minimumSalary)
                    .filter(x -> x.getLastName().charAt(0) > employeeSurNameAfterCharacter)
                    .map(x -> x.getFirstName() + " " + x.getLastName())
                    .sorted()
                    .collect(Collectors.joining(", "));
}
