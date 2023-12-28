package sort;

import java.lang.reflect.Array;
import java.util.*;

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
        System.out.println("-----------------------Before sorting-----------------------------------\n");
        print(fruitlList);
        Collections.sort(fruitlList);
        System.out.println("-----------------------After sorting------------------------------------\n");
        print(fruitlList);
        System.out.println("");

        Collections.sort(fruitlList, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.getName().compareTo(o2.getName());
            } //here we are sorting the list of fruits based on the name of the fruit
        });

        Collections.sort(fruitlList, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.getQuantity() - o2.getQuantity();
            }//here we are sorting the list of fruits based on the quantity of the fruit
        });
        System.out.println("-----------------------After sorting------------------------------------\n");
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
