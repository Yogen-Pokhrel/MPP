package Lab9.prob9;
import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    static  boolean hasVegetarianMeal(){
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    static boolean hasHealthyMenu(){
        return menu.stream().anyMatch(e -> e.getCalories() < 1000);
    }

    static boolean hasUnhealthyMenu(){
        return menu.stream().anyMatch(e -> e.getCalories() > 1000);
    }

    static Optional<Dish> firstMeatItem(){
        return menu.stream().filter(e -> e.getType() == Type.MEAT).findFirst();
    }

    static int calculateTotalCalories(){
        return  menu.stream().reduce(0, (sum, dish) -> sum + dish.getCalories(), Integer::sum);
    }

    static int calculateTotalCaloriesUsingMethodReference(){
        return menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                           new Dish("beef", false, 700, Dish.Type.MEAT),
                           new Dish("chicken", false, 400, Dish.Type.MEAT),
                           new Dish("french fries", true, 530, Dish.Type.OTHER),
                           new Dish("rice", true, 350, Dish.Type.OTHER),
                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
                           new Dish("pizza", true, 550, Dish.Type.OTHER),
                           new Dish("prawns", false, 400, Dish.Type.FISH),
                           new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        //a. Is there any Vegetarian meal available ( return type boolean)
        System.out.println("Is there any vegetarian dish? " + hasVegetarianMeal());

        //b. Is there any healthy menu have calories less than 1000 ( return type boolean)
        System.out.println("Is there any healthy dish with calories less than 1000? " + hasHealthyMenu());

        //c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
        System.out.println("Is there any un healthy dish with calories greater than 1000? " + hasUnhealthyMenu());

        //d. find and return the first item for the type of MEAT( return type Optional<Dish>)
        Optional<Dish> firstMeatItem = firstMeatItem();
        if(firstMeatItem.isPresent()){
            System.out.println("First meat item: " + firstMeatItem.get());
        }else{
            System.out.println("No meat item");
        }

        //e. calculateTotalCalories() in the menu using reduce. (return int);
        System.out.println("Total Calories: " + calculateTotalCalories());

        //f. calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
        System.out.println("Total Calories using method reference : " + calculateTotalCaloriesUsingMethodReference());



        /*----------------Just for Practice---------------------*/
        System.out.println("\n\n");
        boolean allDishesAreVegetarian = menu.stream().allMatch(Dish::isVegetarian);
        System.out.println("Is all vegetarian dish? " + allDishesAreVegetarian);

        boolean noneAreVegetarian = menu.stream().noneMatch(Dish::isVegetarian);
        System.out.println("None are vegetarian dish? " + noneAreVegetarian);

        Optional<Dish> anyVegetarianDish = menu.stream().filter(Dish::isVegetarian).findAny();
        if(anyVegetarianDish.isPresent()){
            System.out.println("Any vegetarian dish: " + anyVegetarianDish.get());
        }else{
            System.out.println("No vegetarian dish");
        }


        Optional<Dish> firstVegetarianDish = menu.stream().filter(Dish::isVegetarian).findFirst();
        if(firstVegetarianDish.isPresent()){
            System.out.println("First vegetarian dish: " + firstVegetarianDish.get());
        }else{
            System.out.println("No vegetarian dish");
        }

    }
}