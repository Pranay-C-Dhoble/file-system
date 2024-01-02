package car.file.writer;

import car.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class CarJsonWriter implements CarFileWriter {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void write(List<Car> data, String outputPath) {
        try {
            String jsonString = objectMapper.writeValueAsString(data);
            FileWriter fileWriter = new FileWriter(outputPath);
            fileWriter.write(jsonString);
            fileWriter.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
