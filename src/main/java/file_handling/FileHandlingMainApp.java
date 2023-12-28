package file_handling;

import file_handling.reader.csv_reader.CsvFileReader;
import file_handling.processor.BedRoomProcessor;
import file_handling.reader.FileReader;
import file_handling.writer.csv_writer.CsvFileWriter;
import file_handling.writer.IFileWriter;

import java.util.List;

public class FileHandlingMainApp {
    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader("src/main/resources/Data/housing_price_dataset.csv");
        BedRoomProcessor bedRoomProcessor = new BedRoomProcessor();
        IFileWriter fileWriter = new CsvFileWriter();

        List data = fileReader.read();
        fileWriter.write(bedRoomProcessor.getHouses(data, 2), "src/main/resources/Data/2bhk.csv");
        fileWriter.write(bedRoomProcessor.getHouses(data, 3), "src/main/resources/Data/3bhk.csv");
        fileWriter.write(bedRoomProcessor.getHouses(data, 4), "src/main/resources/Data/4bhk.csv");
        fileWriter.write(bedRoomProcessor.getHouses(data, 5), "src/main/resources/Data/5bhk.csv");
    }
}
