package filehandling;

import filehandling.reader.csv_reader.CsvFileReader;
import filehandling.processor.BedRoomProcessor;
import filehandling.reader.FileReader;
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

        pdfConverter.write(bedRoomProcessor.getHouses(data, 2), "src/main/resources/Data/2bhk.pdf");
        pdfConverter.write(bedRoomProcessor.getHouses(data, 3), "src/main/resources/Data/3bhk.pdf");
        pdfConverter.write(bedRoomProcessor.getHouses(data, 4), "src/main/resources/Data/4bhk.pdf");
        pdfConverter.write(bedRoomProcessor.getHouses(data, 5), "src/main/resources/Data/5bhk.pdf");
    }
}