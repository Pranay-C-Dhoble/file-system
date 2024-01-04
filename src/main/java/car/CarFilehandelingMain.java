package car;
import car.duplicate.DuplicateRecord;
import car.file.ListingFiles;
import car.file.writer.csvwriter.CarCsvWriter;
import car.file.writer.CarFileWriter;
import car.file.writer.jsonwriter.CarJsonWriter;
import car.file.writer.pdfwriter.CarPdfWriter;

public class CarFilehandelingMain {
    public static void main(String[] args) {
        ListingFiles ex1 = new ListingFiles();
        ex1.listAllFiles("D:\\file-system\\src\\main\\resources\\Car");
        CarFileWriter carFileWriter = new CarCsvWriter();
        carFileWriter.write(ex1.getAllDataList(), "src/main/resources/CollectionOfCars/AllCarData.csv");
        CarJsonWriter carJsonWriter = new CarJsonWriter();
        carJsonWriter.write(ex1.getAllDataList(), "src/main/resources/CollectionOfCars/AllCarData.json");
        CarPdfWriter carPdfWriter = new CarPdfWriter();
        carPdfWriter.write(ex1.getAllDataList(), "src/main/resources/CollectionOfCars/AllCarData.pdf");
        DuplicateRecord duplicateRecord = new DuplicateRecord();
        duplicateRecord.duplicateCars(ex1.getAllDataList());
    }
}


