package prerequisite;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Create an ArrayList with duplicate values
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("apple");
        arrayList.add("orange");
        arrayList.add("banana");

        System.out.println("ArrayList with duplicates: " + arrayList);

        // Convert ArrayList to HashSet to remove duplicates
        HashSet<String> hashSet = new HashSet<>(arrayList);

        // Display the HashSet (no duplicates)
        System.out.println("HashSet without duplicates: " + hashSet);

        // Optional: If you need to convert it back to ArrayList
        ArrayList<String> uniqueList = new ArrayList<>(hashSet);

        // Display the ArrayList without duplicates
        System.out.println("ArrayList without duplicates: " + uniqueList);
    }
}
