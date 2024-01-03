package filehandling.util;

public class PathGenerator {
    public String getPath(int bhk, String type){
        return "src/main/resources/Data/" + bhk + "bhk." + type;
    }
}
