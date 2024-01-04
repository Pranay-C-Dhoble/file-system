package filehandling.duplicatebhk;

import filehandling.model.House;

import java.util.HashMap;
import java.util.List;

public class DuplicateFinder {
    public void duplicateApartment(List data) {
        System.out.println("----------------------------------------------------------");
        System.out.println(" Duplicate Records Finder Started ............");
        System.out.println(" Size of ArrayList : " + data.size());
        HashMap<House, Integer> countMap = new HashMap<>();

        for(Object apartment : data) {
            countMap.put((House) apartment, countMap.getOrDefault(apartment, 0) + 1);
        }
        System.out.println(" Size Of HashMap : " + countMap.size());

        System.out.println(" Count of duplicates:");
        System.out.println("-----------------------Duplicate Apartments-----------------------");
        for (House key : countMap.keySet()) {
            int count = countMap.get(key);
            if (count > 1) {
                System.out.println(key + " -----> " + count);
            }
        }
        if(countMap.size() == data.size()) {
            System.out.println("No duplicate records found");
        }
        System.out.println("----------------------------------------------------------");
    }
}
