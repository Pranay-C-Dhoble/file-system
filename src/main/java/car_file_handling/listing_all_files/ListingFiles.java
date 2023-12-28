package car_file_handling.listing_all_files;

import car_file_handling.car_csv_reader.CarCsvReader;
import car_file_handling.car_csv_reader.CarDataReader;
import car_file_handling.car_csv_writer.CarCsvWriter;
import car_file_handling.car_csv_writer.CarFileWriter;

import java.io.File;
import java.util.List;

public class ListingFiles {
    public void listAllFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("Directory: " + f.getName());
                listAllFiles(f.getAbsolutePath());
            } else {
                System.out.println("File: " + f.getName());
                String fileName = f.getPath();
                System.out.println(fileName);
                CarDataReader carDataReader = new CarCsvReader(fileName);
                List data = carDataReader.read();
                CarFileWriter carFileWriter = new CarCsvWriter();
                carFileWriter.write(data, "src/main/resources/AllCarData.csv");
            }
        }
    }
}
