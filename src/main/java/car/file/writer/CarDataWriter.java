package car.file.writer;

import car.model.Car;

import java.util.List;

public interface CarDataWriter {
    public void write(List<Car> data, String outputPath);
}
