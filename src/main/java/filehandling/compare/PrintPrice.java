package filehandling.compare;

import filehandling.processor.BedRoomProcessor;

import java.util.List;

public class PrintPrice {
    public void highestPrice(List data) {
        BedRoomProcessor bedRoomProcessor = new BedRoomProcessor();
        ComparePrice compare = new ComparePrice();

        List data2 = bedRoomProcessor.getHouses(data, 2);
        System.out.print("Max price of 2bhk : ");
        double bhk2 = compare.getHighestPrice(data2);

        List data3 = bedRoomProcessor.getHouses(data, 3);
        System.out.print("Max price of 3bhk : ");
        double bhk3 = compare.getHighestPrice(data3);

        if(bhk2 > bhk3) {
            System.out.println("2bhk is more expensive than 3bhk");
        } else {
            System.out.println("3bhk is more expensive than 2bhk");
        }
    }
}
