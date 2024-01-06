package bank.matrics;

import bank.model.BankTransaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByGenderMatrics implements MatricsCollector{
    @Override
    public void collect(List<BankTransaction> transactions) {
        Map<Character, List<BankTransaction>> genderGroups = transactions.stream()
                .collect(Collectors.groupingBy(BankTransaction ::getCustGender));

        System.out.println("Transactions done by Male: " + genderGroups.get('M').size());
        System.out.println("Transactions done by Female: " + genderGroups.get('F').size());
        System.out.println("Transactions done by Not Specified: " + genderGroups.get('N').size());
        System.out.println("Transaction done by Transgender: " + genderGroups.get('T').size());

    }
}
