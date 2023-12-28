package car_file_handling;


import car_file_handling.car_csv_reader.CarCsvReader;
import car_file_handling.car_csv_reader.CarDataReader;
import car_file_handling.car_csv_writer.CarCsvWriter;
import car_file_handling.car_csv_writer.CarFileWriter;

import java.io.File;
import java.util.List;

public class CarFilehandelingMain {
    public static void main(String[] args) {
        CarFilehandelingMain ex1 = new CarFilehandelingMain();
        ex1.listAllFiles("D:\\file-system\\src\\main\\resources\\Data\\Car");
    }


    private void listAllFiles(String path) {
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


