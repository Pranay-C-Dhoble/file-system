package bank.matrics;

import bank.model.BankTransaction;

import java.util.List;

public class TransByDOBYear implements MatricsCollector{
    @Override
    public void collect(List<BankTransaction> transactions) {
        long total = count(transactions, 60, 70);
        System.out.println("Transactions done by people between 1960 and 1970 years: " + total);
        total = count(transactions, 70, 80);
        System.out.println("Transactions done by people between 1970 and 1980 years: " + total);
        total = count(transactions, 80, 90);
        System.out.println("Transactions done by people between 1980 and 1990 years: " + total);
        total = count(transactions, 90, 100);
        System.out.println("Transactions done by people between 1990 and 2000 years: " + total);
    }
    private long count(List<BankTransaction> transactions, int start, int end){
        long count = transactions.stream().filter(transaction -> transaction.getCustomerDOB().getYear() >= start
                && transaction.getCustomerDOB().getYear() < end).count();
        return count;
    }
}
