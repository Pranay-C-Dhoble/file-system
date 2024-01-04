package car.duplicate;

import car.model.Car;

import java.util.HashMap;
import java.util.List;

public class DuplicateRecord {
    public void duplicateCars(List data) {
        System.out.println("----------------------------------------------------------");
        System.out.println(" Duplicate Records Finder Started ............");
        System.out.println(" Size of ArrayList : " + data.size());
        HashMap<Car, Integer> countMap = new HashMap<>();

        for(Object car : data) {
            countMap.put((Car) car, countMap.getOrDefault(car, 0) + 1);
        }
        System.out.println(" Size Of HashMap : " + countMap.size());

        System.out.println(" Count of duplicates:");
        System.out.println("-----------------------Duplicate Cars-----------------------");
        for (Car key : countMap.keySet()) {
            int count = countMap.get(key);
            if (count > 1) {
                System.out.println(key + " -----> " + count);
            }
        }
    }
}
