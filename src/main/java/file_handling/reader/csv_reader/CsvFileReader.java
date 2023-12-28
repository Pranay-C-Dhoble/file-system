package file_handling.reader.csv_reader;

import file_handling.model.House;
import file_handling.reader.FileReader;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class CsvFileReader implements FileReader {
    private String path;
    public CsvFileReader(String inputFilePath){
        this.path = inputFilePath;
    }
    @Override
    public List read() {
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String line = reader.readLine();
            List<House> house = new ArrayList<>();
            while ((line = reader.readLine()) != null){
                House h = buildHome(line);
                house.add(h);
            }
            return house;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    private House buildHome(String line) {
        String[] data = line.split(",");
        return House.builder()
                .squareFeet(Integer.parseInt(data[0]))
                .bedrooms(Integer.parseInt(data[1]))
                .bathrooms(Integer.parseInt(data[2]))
                .neighbourhood(data[3])
                .year(Integer.parseInt(data[4]))
                .price(Double.parseDouble(data[5]))
                .build();
    }
}
