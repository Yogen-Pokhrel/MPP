package Lab10.prob2;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <T extends Comparable<T>> T secondSmallest(List<T> list){
        if(list.isEmpty() || list.size() == 1) return null;
        ArrayList<T> lst = new ArrayList<>(list);
        Collections.sort(lst);
        return lst.get(1);
    }

    public static void main(String[] args) {
        System.out.println(secondSmallest(List.of("yogen","dikshya","manju","dinesh")));
        System.out.println(secondSmallest(List.of(12.74,11.85,89.22,23.56)));
        System.out.println(secondSmallest(List.of(99,12,34,54,26)));

    }

}