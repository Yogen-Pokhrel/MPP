package Lab10.prob3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static <T> boolean contains1(List<T> list, T s){
        for(T x:list){
            if(x==null && s==null) return true;
            if(s== null || x==null) continue;
            if(x.equals(s)) return true;
        }
        return false;
    }

    public static void test1(){
        /******* String Check *******/
        List<String> list = Arrays.asList("Bob", "Joe", "Tom");
        boolean result = Main.contains1(list, "Tom");
        System.out.println(result);// this should be true

        result = Main.contains1(list, "Togi");
        System.out.println(result);// this should be false
    }

    public static void test2(){
        /******* Employees Check *******/
        List<Employee> employeeList = Arrays.asList(
                new Employee("Yogen", "Pokhrel", 95000.0),
                new Employee("Dikshya", "Prasai", 105000.0)
        );
        boolean result = Main.contains1(employeeList, new Employee("Yogen", "Pokhrel", 95000.0));
        System.out.println(result);// this should be true

        result = Main.contains1(employeeList, new Employee("Yogendra", "Pokhrel", 95000.0));
        System.out.println(result); // this should be false
    }

    public static void test3(){
        /******* Accounts Check*******/
        List<Account> accountsList = Arrays.asList(
                new Account(new Customer("Yogen", "Pokhrel"), "7L45dg", 67000.0),
                new Account(new Customer("Dikshya", "Prasai"), "7L45dg", 67000.0)
        );

        boolean result = Main.contains1(accountsList, new Account(new Customer("Yogen", "Pokhrel"), "7L45dg", 67000.0));
        System.out.println(result);// this should be true

        result = Main.contains1(accountsList, new Account(new Customer("Dikshya", "Pokhrel"), "7L45dg", 27000.0));
        System.out.println(result); // this should be false
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

}
