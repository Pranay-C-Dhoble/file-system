package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSorter {
    public static void main(String[] args) {
        String[] fruit = {"Pineapple", "Apple", "Orange", "Banana", "Grapes", "Mango", "Watermelon"};
        print(fruit);
        Arrays.sort(fruit);
        System.out.println("-----------------------After sorting---------------------------------");
        print(fruit);

        Integer[] numbers = {1, 5, 3, 2, 4};
        System.out.println("-----------------------Before sorting---------------------------------");
        print(numbers);
        Arrays.sort(numbers);
        System.out.println("-----------------------After sorting----------------------------------");
        print(numbers);

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Pineapple");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Mango");
        System.out.println("-----------------------Before sorting----------------------------------");
        print(fruits);
        Collections.sort(fruits);
        System.out.println("-----------------------After sorting-----------------------------------");
        print(fruits);

        ArrayList<Fruit> fruitlList = new ArrayList<>();
        fruitlList.add(Fruit.builder().quantity(5).name("Pineapple").description("Good").build());
        fruitlList.add(Fruit.builder().quantity(1).name("Apple").description("Good").build());
        fruitlList.add(Fruit.builder().quantity(3).name("Orange").description("Good").build());
        fruitlList.add(Fruit.builder().quantity(2).name("Banana").description("Good").build());
        fruitlList.add(Fruit.builder().quantity(4).name("Grapes").description("Good").build());
        System.out.println("-----------------------Before sorting-----------------------------------");
        print(fruitlList);
        Collections.sort(fruitlList);
        System.out.println("-----------------------After sorting------------------------------------");
        print(fruitlList);
    }




    private static void print(Object[] fruit) {
        for (Object o: fruit) {
            System.out.println(o);
        }
    }
    private static void print(List fruits) {
        for (Object fruit: fruits) {
            System.out.println(fruit);
        }
    }
}
