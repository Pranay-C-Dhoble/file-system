package bank.writer;

import bank.model.BankTransaction;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class CSVTransWriter {
    public void csvWriter(List<BankTransaction> transactions, String outputPath) {
        File file = new File(outputPath);
        StringBuffer sb = new StringBuffer();
        for (BankTransaction transaction : transactions) {
            String line = toCsv(transaction);
            sb.append(line);
            sb.append("\n");
        }
        String[] header = "TransactionID,CustomerID,CustomerDOB,CustGender,CustLocation,CustAccountBalance,TransactionDate,TransactionTime,TransactionAmount (INR)".split(",");
        try{
            FileWriter fw = new FileWriter(file);
            fw.write(Arrays.toString(header));
            fw.write("\n");
            fw.write(sb.toString());
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private String toCsv(BankTransaction transaction){
        return transaction.getTransactionID() + ","
                + transaction.getCustomerID() + ","
                + transaction.getCustomerDOB() + ","
                + transaction.getCustGender() + ","
                + transaction.getCustLocation() + ","
                + transaction.getCustAccountBalance() + ","
                + transaction.getTransactionDate() + ","
                + transaction.getTransactionTime() + ","
                + transaction.getTransactionAmount();
    }
}
//"TransactionID","CustomerID","CustomerDOB","CustGender","
// CustLocation","CustAccountBalance","TransactionDate","TransactionTime","TransactionAmount (INR)"