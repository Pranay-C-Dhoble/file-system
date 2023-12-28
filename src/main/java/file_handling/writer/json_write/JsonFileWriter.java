package file_handling.writer.json_write;

import com.fasterxml.jackson.databind.ObjectMapper;
import file_handling.writer.IFileWriter;

import java.io.FileWriter;
import java.util.List;

public class JsonFileWriter implements IFileWriter {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void write(List data, String outputPath) {
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
