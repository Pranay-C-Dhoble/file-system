package car.file;

import car.file.reader.CarCsvReader;
import car.file.reader.CarDataReader;
import car.file.writer.CarCsvWriter;
import car.file.writer.CarFileWriter;
import car.model.Car;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListingFiles {
    private List<Car> allDataList = new ArrayList<>();

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
                allDataList.addAll(data); // Add data from the current file to the cumulative list
            }
        }
    }
    public List<Car> getAllDataList() {
        return allDataList;
    }
}