package car_file_handling.car_csv_writer;

import java.util.List;

public interface CarDataWriter {
    public void write(List data, String outputPath);
}
