package house_price_data_sheet;

import java.io.*;
import java.util.Scanner;

public class DataReader {
    public static void main(String[] args) {
        File file = new File("src/main/resources/Data/housing_price_dataset.csv");
        //read the data from the file using BufferedReader
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }



    }
}

