package car2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CombineCSVFiles {
    public static void main(String[] args) {
        // List of CSV files to combine
        String[] inputFiles = {"src/main/resources/car/audi.csv",
                "src/main/resources/car/bmw.csv",
                "src/main/resources/car/ford.csv","src/main/resources/car/hyundi.csv",
                "src/main/resources/car/merc.csv","src/main/resources/car/skoda.csv",
                "src/main/resources/car/toyota.csv","src/main/resources/car/vauxhall.csv",
                "src/main/resources/car/vw.csv"};
        String outputFile = "src/main/resources/combinedFiles.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Iterate through each input file
            for (String inputFile : inputFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                    // Read and write data in chunks
                    char[] buffer = new char[8192];
                    int charsRead;
                    while ((charsRead = reader.read(buffer, 0, buffer.length)) != -1) {
                        writer.write(buffer, 0, charsRead);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle exceptions during file reading
                }
            }

            System.out.println("Files combined successfully.");

        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions during file writing
        }
    }
}

