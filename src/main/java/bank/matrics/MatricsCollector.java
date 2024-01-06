package bank.matrics;

import bank.model.BankTransaction;

import java.util.List;

public interface MatricsCollector {
    public void collect(List<BankTransaction> transactions);
}
