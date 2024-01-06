package bank.utils;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSpliterUtils {
    public static void main(String[] args){
        split("src/main/resources/Bank/bank_transactions.csv", 50000, "src/main/resources/Bank_Output/");
    }

    public static void split(String inputpath, int partationCount, String outputpath){
        try{
            CSVReader reader = new CSVReader(new FileReader(inputpath)); //how to skip the first line
            List<String[]> strings = reader.readAll(); //how to skip the first line
            strings.remove(0);
            reader.close();
            List<List<String[]>> partitiondata = Lists.partition(strings, partationCount);
            String[] head = "TransactionID,CustomerID,CustomerDOB,CustGender,CustLocation,CustAccountBalance,TransactionDate,TransactionTime,TransactionAmount (INR)".split(",");

            for(List<String[]> subList : partitiondata){
                String[] header = subList.get(0);
                String filename = header[0].split(" ")[0];
                String filepath = outputpath + filename + ".csv";
                CSVWriter writer = new CSVWriter(new FileWriter(filepath));
                writer.writeNext(head);
                writer.writeAll(subList);
                writer.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
