package housepricedatasheet;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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
            List data = homes;
            Collections.sort(data);
            // List<House> houses2bhk = houses.stream().filter(house -> house.bedrooms == 2).collect(Collectors.toList());
            // dataWrite(houses2bhk);

            List<Home> homes2bhk = getBedrooms(homes, 2);
            dataWrite(homes2bhk, generatePath(2));

            List<Home> homes3bhk = getBedrooms(homes, 3);
            dataWrite(homes3bhk, generatePath(3));

            List<Home> homes4bhk = getBedrooms(homes, 4);
            dataWrite(homes4bhk, generatePath(4));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String generatePath(int count) {
        return "src/main/resources/Data/" + count + "bhk.csv";
    }

    private static List<Home> getBedrooms(List<Home> homes, int count) {
        List<Home> dataOfRooms = homes.stream().filter(home -> home.getBedrooms()== count).toList();
        return dataOfRooms;
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




