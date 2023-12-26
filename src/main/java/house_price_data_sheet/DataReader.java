package house_price_data_sheet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static void main(String[] args) {
        File file = new File("src/main/resources/Data/housing_price_dataset.csv");
        //read the data from the file using BufferedReader

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            List<Home> homes = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                Home home = buildHome(line); // here home is the object of Home class
                homes.add(home);
            }
            System.out.println("Total Homes: " + homes.size());

            List<Home> homes2bhk = homes.stream().filter(home -> home.getBedrooms()== 2).toList();
            dataWrite(homes2bhk, "src/main/resources/Data/2bhk.csv");

            List<Home> homes3bhk = homes.stream().filter(home -> home.getBedrooms()== 3).toList();
            dataWrite(homes3bhk, "src/main/resources/Data/3bhk.csv");

            List<Home> homes4bhk = homes.stream().filter(home -> home.getBedrooms()== 4).toList();
            dataWrite(homes4bhk, "src/main/resources/Data/4bhk.csv");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void dataWrite(List<Home> location , String path) {
        File file = new File(path);
        StringBuffer sb = new StringBuffer();
        for (Home home : location) {
            String line = toCsv(home);
            sb.append(line);
            sb.append("\n");
        }
        try{
            FileWriter fw = new FileWriter(file);
            fw.write(sb.toString());
            fw.flush();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private static String toCsv(Home home) {
        return home.getSquareFeet()
                + "," + home.getBedrooms()
                + "," + home.getBathrooms()
                + "," + home.getNeighbourhood()
                + "," + home.getYear()
                + "," + home.getPrice();
    }
    private static Home buildHome(String line) {
        String[] tokens = line.split(",");
        return Home.builder()
                .squareFeet(Integer.parseInt(tokens[0]))
                .bedrooms(Integer.parseInt(tokens[1]))
                .bathrooms(Integer.parseInt(tokens[2]))
                .neighbourhood(tokens[3])
                .year(Integer.parseInt(tokens[4]))
                .price(Double.parseDouble(tokens[5]))
                .build();
    }
}




