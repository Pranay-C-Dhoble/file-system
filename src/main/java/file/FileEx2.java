package file;

import java.io.*;
import java.util.Scanner;

public class FileEx2 {
    public static void main(String[] args) {
        File file = new File("D:\\filehandelling\\student_data.csv");

        // 1 using BufferedReader
        try{

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        // 2 using Scanner
        try{
            Scanner sc = new Scanner(new FileInputStream(file));

            while(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
        }catch (IOException ex){

        }

        // 3 using FileReader --> Character by Character
        try{

            FileReader fr = new FileReader(file);
            int i = 0;
            while((i = fr.read()) != - 1){
                System.out.print((char) i);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
