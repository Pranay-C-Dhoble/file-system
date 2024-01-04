package car;
import car.duplicate.DuplicateRecord;
import car.file.ListingFiles;
import car.file.writer.CarCsvWriter;
import car.file.writer.CarFileWriter;
import car.file.writer.CarJsonWriter;

public class CarFilehandelingMain {
    public static void main(String[] args) {
        ListingFiles ex1 = new ListingFiles();
        ex1.listAllFiles("D:\\file-system\\src\\main\\resources\\Car");
        CarFileWriter carFileWriter = new CarCsvWriter();
        carFileWriter.write(ex1.getAllDataList(), "src/main/resources/AllCarData.csv");
        CarJsonWriter carJsonWriter = new CarJsonWriter();
        carJsonWriter.write(ex1.getAllDataList(), "src/main/resources/AllCarData.json");
//        DuplicateRecord duplicateRecord = new DuplicateRecord();
//        duplicateRecord.findDuplicates(ex1.getAllDataList());
    }
}


