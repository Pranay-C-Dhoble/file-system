package car;
import car.file.ListingFiles;
import car.file.writer.CarCsvWriter;
import car.file.writer.CarFileWriter;

public class CarFilehandelingMain {
    public static void main(String[] args) {
        ListingFiles ex1 = new ListingFiles();
        ex1.listAllFiles("D:\\file-system\\src\\main\\resources\\Car");
        CarFileWriter carFileWriter = new CarCsvWriter();
        carFileWriter.write(ex1.getAllDataList(), "src/main/resources/AllCarData.csv");
    }
}


