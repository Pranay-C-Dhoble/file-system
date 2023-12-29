package car_file_handling.car_model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car implements Comparable{
    private String model;
    private int year;
    private long price;
    private String transmission;
    private long mileage;
    private String fuelType;
    private int tax;
    private double mpg;
    private double engineSize;

    @Override
    public String toString() {
        return model +
                "," + year +
                "," + price +
                "," + transmission +
                "," + mileage +
                "," + fuelType +
                "," + tax +
                "," + mpg +
                "," + engineSize;
    }

    @Override
    public int compareTo(Object o) {
        Car car = (Car) o; //type casting
        return this.transmission.compareTo(car.transmission);
    }

    //how many types of casting in java
    //1. primitive casting
    //2. object casting
    //3. generic casting

    //primitive casting
    //int a = 10;
    //double b = a; //implicit casting
    //double b = (double) a; //explicit casting

    //object casting
    //Object a = new Object();
    //String b = (String) a; //explicit casting

    //generic casting
    //List a = new ArrayList();
    //List<String> b = (List<String>) a; //explicit casting
}
