package car.file.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import car.model.Car;

public class CarCsvWriter implements CarFileWriter {
    @Override
    public void write(List<Car> data, String outputPath) {
        BufferedWriter fw = null;
        try {
            fw = new BufferedWriter(new FileWriter(outputPath));
            fw.write("model,year,price,transmission,mileage,fuleType,tax,mpg,engineSize\n");
            for (Car car : data) {
                fw.write(car.toString() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
