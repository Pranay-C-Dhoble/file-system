package filehandling;

import filehandling.reader.csv_reader.CsvFileReader;
import filehandling.processor.BedRoomProcessor;
import filehandling.reader.FileReader;
import filehandling.util.PathGenerator;
import filehandling.writer.converttopdf.PdfConverter;
import filehandling.writer.csvwriter.CsvFileWriter;
import filehandling.writer.IFileWriter;
import filehandling.writer.jsonwrite.JsonFileWriter;

import java.util.Collections;
import java.util.List;


public class FileHandlingMainApp {
    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader("src/main/resources/Data/housing_price_dataset.csv");
        BedRoomProcessor bedRoomProcessor = new BedRoomProcessor();
        IFileWriter fileWriter = new CsvFileWriter();
        IFileWriter jsonFileWriter = new JsonFileWriter();
        PdfConverter pdfConverter = new PdfConverter();
        PathGenerator pathGenerator = new PathGenerator();

        List data = fileReader.read();
        Collections.sort(data); //Collections.sort() method is used to sort the elements present in the specified list of Collection in ascending order.

        fileWriter.write(bedRoomProcessor.getHouses(data, 2), pathGenerator.getPath(2, "csv"));
        fileWriter.write(bedRoomProcessor.getHouses(data, 3), pathGenerator.getPath(3, "csv"));
        fileWriter.write(bedRoomProcessor.getHouses(data, 4), pathGenerator.getPath(4, "csv"));
        fileWriter.write(bedRoomProcessor.getHouses(data, 5), pathGenerator.getPath(5, "csv"));

        jsonFileWriter.write(bedRoomProcessor.getHouses(data, 2), pathGenerator.getPath(2, "json"));
        jsonFileWriter.write(bedRoomProcessor.getHouses(data, 3), pathGenerator.getPath(3, "json"));
        jsonFileWriter.write(bedRoomProcessor.getHouses(data, 4), pathGenerator.getPath(4, "json"));
        jsonFileWriter.write(bedRoomProcessor.getHouses(data, 5), pathGenerator.getPath(5, "json"));

        pdfConverter.write(bedRoomProcessor.getHouses(data, 2), pathGenerator.getPath(2, "pdf"));
        pdfConverter.write(bedRoomProcessor.getHouses(data, 3), pathGenerator.getPath(3, "pdf"));
        pdfConverter.write(bedRoomProcessor.getHouses(data, 4), pathGenerator.getPath(4, "pdf"));
        pdfConverter.write(bedRoomProcessor.getHouses(data, 5), pathGenerator.getPath(5, "pdf"));
    }
}