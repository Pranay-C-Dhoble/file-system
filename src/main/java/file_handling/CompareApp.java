package file_handling;

import file_handling.compare.ComparePrice;
import file_handling.processor.BedRoomProcessor;
import file_handling.reader.FileReader;
import file_handling.reader.csv_reader.CsvFileReader;

import java.util.List;

public class CompareApp {
    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader("src/main/resources/Data/housing_price_dataset.csv");
        BedRoomProcessor bedRoomProcessor = new BedRoomProcessor();
        List data = fileReader.read();
//        ComparePrice compare = new ComparePrice();

        List data2 = bedRoomProcessor.getHouses(data, 2);
        System.out.print("Max price of 2bhk : ");
        double bhk2 = ComparePrice.getHighestPrice(data2);

        List data3 = bedRoomProcessor.getHouses(data, 3);
        System.out.print("Max price of 3bhk : ");
        double bhk3 = ComparePrice.getHighestPrice(data3);

        if(bhk2 > bhk3) {
            System.out.println("2bhk is more expensive than 3bhk");
        } else {
            System.out.println("3bhk is more expensive than 2bhk");
        }

    }
}