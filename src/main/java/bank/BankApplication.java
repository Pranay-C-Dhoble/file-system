package bank;

import bank.matrics.MatricsCollector;
import bank.matrics.TransactionByGenderMatrics;
import bank.model.BankTransaction;
import bank.pathgenerator.Path;
import bank.reader.TransactionReader;

import java.util.List;

public class BankApplication {
    public static void main(String[] args) {
        TransactionReader reader = new TransactionReader();
        String fileName = Path.find("src/main/resources/Bank_Output");
        List<BankTransaction> transactions = reader.read(fileName);
        MatricsCollector metrics = new TransactionByGenderMatrics();
        System.out.println(transactions.size());
        metrics.collect(transactions);
    }
}
