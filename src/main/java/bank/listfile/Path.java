package bank.listfile;

import bank.model.BankTransaction;
import bank.reader.TransactionReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Path {
    List<BankTransaction> allDataList = new ArrayList<>();
    public void find(String InputPath) {
        try{
            File file = new File(InputPath);
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println("Directory: " + f.getName());
                        find(f.getAbsolutePath());
                    }else{
                        process(f);
                    }
                }
            }else {
                process(file);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void process(File f) {
        System.out.println("File: " + f.getName());
        String fileName = f.getPath();
        System.out.println(fileName);

        TransactionReader transactionReader = new TransactionReader();
        List data = transactionReader.read(fileName);
        allDataList.addAll(data);
    }

    public List<BankTransaction> getAllDataList(){
        return allDataList;
    }

}
