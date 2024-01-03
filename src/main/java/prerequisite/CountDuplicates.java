package prerequisite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class CountDuplicates {
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

        // Count duplicates using a HashMap
        HashMap<String, Integer> countMap = new HashMap<>();

        for (String element : arrayList) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
            //getOrDefault is used to get the value mapped with specified key.
            //countMap.getOrDefault(element, 0): This part retrieves the current count of the element from the countMap.
            // If the element is not present in the map,
            // it returns the default value, which is 0.
            // This is done to handle the case where the element is encountered for the first time.

            //countMap.getOrDefault(element, 0) + 1: This part increments the retrieved count by 1.
            // If the element is already present in the map, it increases the count by 1.
            // If the element is not present (i.e., it's the first occurrence), it starts with 0 and adds 1.

            //countMap.put(element, ...): This part puts the updated count back into the countMap,
            // associating it with the element. If the element was not present, a new entry is created; otherwise,
            // the existing entry is updated with the incremented count.
        }

        // Display the count of duplicates
        System.out.println("Count of duplicates:");
        for (String key : countMap.keySet()) {
            int count = countMap.get(key);
            if (count > 1) {
                System.out.println(key + ": " + count);
            }
        }
    }
}

