package filehandling.writer.csvwriter;

import filehandling.writer.IFileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter implements IFileWriter {
    public void write(List data, String outputPath) {
        try {
            File file = new File(outputPath);
            FileWriter fw = new FileWriter(file);
            fw.write("squareFeet,bedrooms,bathrooms,neighbourhood,year,price\n");
            data.forEach(d -> {
                try {
                    fw.write(d.toString());
                    fw.write("\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
