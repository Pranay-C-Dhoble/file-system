package prerequisite;


import car.file.reader.csvreader.CarCsvReader;
import car.model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CarDuplicate {
    private static List<Car> allDataList = new ArrayList<>();
    public static void main(String[] args) {

        CarCsvReader carCsvReader = new CarCsvReader("src/main/resources/AllCarData.csv");
        List data = carCsvReader.read();
        System.out.println(" Size Of ArrayList : "+data.size());
//        for(Object car : data){
//            System.out.println(car);
//        }
        HashSet<Car> hashSet = new HashSet<>(data);
        System.out.println(" Size Of HashSet : "+ hashSet.size());
//        for(Car car : hashSet){
//            System.out.println(car);
//        }

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
