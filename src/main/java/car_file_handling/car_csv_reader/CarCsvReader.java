package car_file_handling.car_csv_reader;

import car_file_handling.car_model.Car;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CarCsvReader implements CarFileReader {
    private String path;
    public CarCsvReader(String inputFilePath){
        this.path = inputFilePath;
    }
    @Override
    public List read() {
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String line = reader.readLine();
            List<Car> cars = new ArrayList<>();
            while ((line = reader.readLine()) != null){
                Car c = carList(line);
                cars.add(c);
            }
            return cars;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    private Car carList(String line) {
        String[] data = line.split(",");
        return Car.builder()
                .model(data[0])
                .year(Integer.parseInt(data[1]))
                .price(Integer.parseInt(data[2]))
                .transmission(data[3])
                .mileage(Integer.parseInt(data[4]))
                .fuelType(data[5])
                .tax(Integer.parseInt(data[6]))
                .mpg(Double.parseDouble(data[7]))
                .engineSize(Double.parseDouble(data[8]))
                .build();
    }
}