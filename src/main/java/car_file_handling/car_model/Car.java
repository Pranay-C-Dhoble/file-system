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
        Car car = (Car) o;
        return this.transmission.compareTo(car.transmission);
    }
}
