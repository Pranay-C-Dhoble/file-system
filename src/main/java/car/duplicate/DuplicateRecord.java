package car.duplicate;

import car.model.Car;

import java.util.List;

public class DuplicateRecord {
    public void findDuplicates(List<Car> cars) {
        System.out.println("Finding duplicate records");
        for (int i = 0; i < cars.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < cars.size(); j++) {
                if (cars.get(i).equals(cars.get(j))) {
                    count++;
                }
            }
            if (count > 7) {
                System.out.println(cars.get(i) + " is duplicate");
            }
        }
    }
}
