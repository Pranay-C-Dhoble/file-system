package filehandling;

import filehandling.compare.ComparePrice;
import filehandling.compare.PrintPrice;
import filehandling.duplicatebhk.DuplicateFinder;
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
        DuplicateFinder duplicateFinder = new DuplicateFinder();

        List data = fileReader.read();

        duplicateFinder.duplicateApartment(data);

        Collections.sort(data); //Collections.sort() method is used to sort the elements present in the specified list of Collection in ascending order.


        for(int i = 2; i <= 5; i++) {
            List processData = bedRoomProcessor.getHouses(data, i);
            fileWriter.write(processData, pathGenerator.getPath(i, "csv"));
            jsonFileWriter.write(processData, pathGenerator.getPath(i, "json"));
            pdfConverter.write(processData, pathGenerator.getPath(i, "pdf"));
            System.out.println("---------------------------------------------------------------------");
        }

        System.out.println("-----------------Highest Price of 2bhk and 3bhk----------------------");

        PrintPrice printPrice = new PrintPrice();
        printPrice.highestPrice(data);


    }
}