package Lab9.prob10;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface TriFunction<T,U,V,R>{
	R apply(T param1, U param2, V param3);
}

class Human
{
	String name;
	int age;
	String gender;
	
	public Human(String name){
		this.name = name;
	}
	public Human(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public Human(String name,int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}

public class ConstructorReference {
public static void main(String args[]){
	Human[] list = {
			new Human("Joe",35,"Male"),
			new Human("Jane",45,"Female"),
			new Human("John",30,"Male"),
			new Human("Dikshya",24,  "Female"),
			new Human("Sushma"),
			new Human("Hari", 55, "male")
	};
	
    // Query 1  : Print only Female candidates names
	System.out.println("Only female candidates names: ");
	Arrays.stream(list).filter(e -> Optional.ofNullable(e.getGender()).orElse("").equalsIgnoreCase("Female")).map(Human::getName).forEach(System.out::println);
	

    // Query 2 : Create an object by choosing suitable Interface to the specified constructors(Totally 3 constructors)
	// using forth type of Method Reference ClassName::new. Then print the object status
	TriFunction<String, Integer, String, Human> factory = Human::new;
	Human h1 = factory.apply("Yogen", 29, "Male");

	BiFunction<String, Integer, Human> factory2 = Human::new;
	Human h2 = factory2.apply("Dinesh", 20);

	Function<String, Human> factory3 = Human::new;
	Human h3 = factory3.apply("Dikshya");

	System.out.println();
	System.out.println("Human 1: " + h1);
	System.out.println("Human 2: " + h2);
	System.out.println("Human 3: " + h3);

	// Query 3 : Count the male candidates whose age is more than 30
	long count = Arrays.stream(list).filter(human -> Optional.ofNullable(human.getGender()).orElse("").equalsIgnoreCase("Male"))
			.filter(human -> human.getAge() > 30)
			.count();
	System.out.println("\nThe number of male candidates whose age is more than 30: " + count);
}



}
