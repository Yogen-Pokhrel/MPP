package Lab10.prob1;

import java.util.*;

public class GroupUtil {
	public static <T> Group<T> copy(Group<T> group) {
		List<T> elements = group.getElements();
		Group<T> grp = new Group<T>(group.getSpecialElement(), elements);
		return grp;
	}

	// Test using this main method
	public static void main(String[] args) {
		List<Integer> elements1 = Arrays.asList(1, 2, 3, 4);
		Group<Integer> group1 = new Group<>(1, elements1);
		System.out.println("Original Group: " + group1);

		Group<Integer> copy1 = copy(group1);
		System.out.println("Copied Group: " + copy1);

		List<String> elements2 = Arrays.asList("C++", "C#", "Java", "Kotlin");
		Group<String> group2 = new Group<>("Java", elements2);
		System.out.println("Original Group: " + group2);

		Group<String> copy2 = copy(group2);
		System.out.println("Copied Group: " + copy2);
	}
}
