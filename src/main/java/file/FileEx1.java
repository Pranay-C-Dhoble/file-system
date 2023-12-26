package file;

import java.io.File;
import java.io.IOException;

public class FileEx1 {
    public static void main(String[] args) {
        // Operation - READ, Write, Delete, Create
        // ONE GO
        // Stream
        // Internally it has buffer (100B) (1KB) (2MB)
        // Chunks (portion of data)

        // package -> java.io
        // InputStream
        // OutputStream

        // Types of File
        // Text and Binary
        // FileInputStream

        // write a program to create new file

        File newFile = new File("D:\\filehandelling\\newFile.txt");
        try{
            if(!newFile.exists()) {
                newFile.createNewFile();
            }else {
                newFile.delete();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
