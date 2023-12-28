package car_file_handling.car_csv_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CarCsvWriter implements CarFileWriter {
    @Override
    public void write(List data, String outputPath) {
        try {
            File file = new File(outputPath);
            FileWriter fw = new FileWriter(file);
            fw.write("model,year,price,transmission,mileage,fuleType,tax,mpg,engineSize\n");
            data.forEach(d -> {
                try {
                    fw.write(d.toString());
                    fw.write("\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
