package file_handling;

import file_handling.reader.csv_reader.CsvFileReader;
import file_handling.processor.BedRoomProcessor;
import file_handling.reader.FileReader;
import file_handling.writer.csv_writer.CsvFileWriter;
import file_handling.writer.IFileWriter;
import file_handling.writer.json_write.JsonFileWriter;

import java.util.Collections;
import java.util.List;


public class FileHandlingMainApp {
    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader("src/main/resources/Data/housing_price_dataset.csv");
        BedRoomProcessor bedRoomProcessor = new BedRoomProcessor();
        IFileWriter fileWriter = new CsvFileWriter();
        IFileWriter jsonFileWriter = new JsonFileWriter();

        List data = fileReader.read();
        Collections.sort(data); //Collections.sort() method is used to sort the elements present in the specified list of Collection in ascending order.

        fileWriter.write(bedRoomProcessor.getHouses(data, 2), "src/main/resources/Data/2bhk.csv");
        fileWriter.write(bedRoomProcessor.getHouses(data, 3), "src/main/resources/Data/3bhk.csv");
        fileWriter.write(bedRoomProcessor.getHouses(data, 4), "src/main/resources/Data/4bhk.csv");
        fileWriter.write(bedRoomProcessor.getHouses(data, 5), "src/main/resources/Data/5bhk.csv");

        jsonFileWriter.write(bedRoomProcessor.getHouses(data, 2), "src/main/resources/Data/2bhk.json");
        jsonFileWriter.write(bedRoomProcessor.getHouses(data, 3), "src/main/resources/Data/3bhk.json");
        jsonFileWriter.write(bedRoomProcessor.getHouses(data, 4), "src/main/resources/Data/4bhk.json");
        jsonFileWriter.write(bedRoomProcessor.getHouses(data, 5), "src/main/resources/Data/5bhk.json");
    }
}