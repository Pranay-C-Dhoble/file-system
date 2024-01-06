package bank.matrics;

import bank.model.BankTransaction;

import java.util.List;
import java.util.Map;

public class TransByLocation implements MatricsCollector{

    @Override
    public void collect(List<BankTransaction> transactions) {
        System.out.println("Transaction done by Location: ");
        Map<String, List<BankTransaction>> groupByLocation = transactions.stream()
                .collect(java.util.stream.Collectors.groupingBy(BankTransaction::getCustLocation));

        groupByLocation.forEach((location, transaction) -> {
            Map<Character, List<BankTransaction>> groupByGender = transaction.stream()
                    .collect(java.util.stream.Collectors.groupingBy(BankTransaction::getCustGender));

            if(location.equals("BANGALORE")){
                state(location, transaction, groupByGender);
            }
            if(location.equals("CHENNAI")){
                state(location, transaction, groupByGender);
            }
            if(location.equals("MUMBAI")){
                state(location, transaction, groupByGender);
            }
            if(location.equals("DELHI")){
                state(location, transaction, groupByGender);
            }
            if(location.equals("KOLKATA")){
                state(location, transaction, groupByGender);
            }
            if(location.equals("HYDERABAD")){
                state(location, transaction, groupByGender);
            }
        });

    }
    private static void state(String location, List<BankTransaction> transaction, Map<Character, List<BankTransaction>> groupByGender){
        System.out.print(location + " Total Transactions: " + transaction.size()+ " :  ");
        groupByGender.forEach((k,v) -> System.out.print("["+ k+" : "+ v.size()+"] "));
        System.out.println();
    }
}
