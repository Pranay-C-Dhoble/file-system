package filehandling.util;

public class PathGenerator {
    public String getPath(int bhk, String type){
        if(type.equals("csv")){
            return "src/main/resources/Output/CSV/" + bhk + "BHK.csv";
        }
        else if(type.equals("json")){
            return "src/main/resources/Output/JSON/" + bhk + "BHK.json";
        }
        else if(type.equals("pdf")){
            return "src/main/resources/Output/PDF/" + bhk + "BHK.pdf";
        }
        else{
            return null;
        }
    }
}
