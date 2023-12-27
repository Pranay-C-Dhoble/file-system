package file;

import java.io.File;

public class DirectoryListEx1 {
    public static void main(String[] args) {
        DirectoryListEx1 ex1 = new DirectoryListEx1();
        ex1.listAllFiles("D:\\Java Program");
    }
    private void listAllFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for(File f : files){
            if(!f.getName().startsWith(".")) {

                if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getName());
                    listAllFiles(f.getAbsolutePath());
                } else {
                    System.out.println("File: " + f.getName());
                }
            }
            else{
                System.out.println("Hidden File: " + f.getName());
            }
        }
    }
}
