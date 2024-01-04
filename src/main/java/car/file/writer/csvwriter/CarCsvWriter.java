package car.file.writer.csvwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import car.file.writer.CarFileWriter;
import car.model.Car;

public class CarCsvWriter implements CarFileWriter {
    @Override
    public void write(List<Car> data, String outputPath) {
        try {
            File file = new File(outputPath);
            FileWriter fw = new FileWriter(file);
            fw.write("model,year,price,transmission,mileage,fuleType,tax,mpg,engineSize\n");
            for(Car car : data) {
                fw.write(car.toString());
                fw.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
