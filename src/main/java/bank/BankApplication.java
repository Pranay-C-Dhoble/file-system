package bank;

import bank.listfile.Path;
import bank.matrics.MatricsCollector;
import bank.matrics.TransByDOBYear;
import bank.matrics.TransByLocation;
import bank.matrics.TransactionByGenderMatrics;
import bank.model.BankTransaction;
import bank.writer.CSVTransWriter;

import java.util.List;

public class BankApplication {
    public static void main(String[] args) {
        Path path = new Path();
        path.find("src/main/resources/Bank_Output");
        List<BankTransaction> data = path.getAllDataList();

//        CSVTransWriter csvTransWriter = new CSVTransWriter();
//        csvTransWriter.csvWriter(data, "src/main/resources/Bank_Clean_data/bank_clean_transactions.csv");
//        System.out.println("Total Transactions: " + data.size());

        MatricsCollector metrics = new TransactionByGenderMatrics();
        System.out.println("Total Transactions: " + data.size());
        metrics.collect(data);

        System.out.println("--------------------------------------------------");
        TransByLocation transByLocation = new TransByLocation();
        transByLocation.collect(data);

        System.out.println("--------------------------------------------------");
        TransByDOBYear transByDOBYear = new TransByDOBYear();
        transByDOBYear.collect(data);
    }
}
