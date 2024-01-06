package filehandling.writer.jsonwrite;

import com.fasterxml.jackson.databind.ObjectMapper;
import filehandling.model.BedRoomCount;
import filehandling.writer.IFileWriter;

import java.io.FileWriter;
import java.util.List;

public class JsonFileWriter implements IFileWriter {
    ObjectMapper objectMapper = new ObjectMapper();


    public static void write(BedRoomCount metricResult){
        System.out.println(" ");
        System.out.println("Writing to JSON file");
        try{
            String jsonString = new ObjectMapper().writeValueAsString(metricResult);
            FileWriter fileWriter = new FileWriter("src/main/resources/output/BedRoomNeighbourhoodmatric.json");
            fileWriter.write(jsonString);
            fileWriter.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void write(List data, String outputPath) {
        System.out.println("Size Of ArrayList is : " + data.size() +"---->"+ outputPath);
        System.out.println("Writing to JSON file");
        try{
            String jsonString = objectMapper.writeValueAsString(data);
            FileWriter fileWriter = new FileWriter(outputPath);
            fileWriter.write(jsonString);
            fileWriter.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
