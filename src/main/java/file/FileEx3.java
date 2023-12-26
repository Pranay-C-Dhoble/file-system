package file;

import java.io.*;

public class FileEx3 {
    public static void main(String[] args) {
        //OutputStream
        // FileOutputStream
        // FileWriter
        //
//        BufferedWriter

        try {

            String text = "I am learning java";
            FileOutputStream fos = new FileOutputStream(new File("D:\\filehandelling\\filehandle.txt"));
            fos.write(text.getBytes());

            BufferedWriter bmw = new BufferedWriter(new FileWriter(new File("D:\\filehandelling\\filehandle1.txt")));
            bmw.write("BMW Car aayegi... 20??");
            bmw.flush();

            PrintStream ps = new PrintStream(new FileOutputStream(new File("D:\\filehandelling\\filehandle2.txt"), true));
            ps.println("Test");
            ps.println("Print karenge...");

            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}


