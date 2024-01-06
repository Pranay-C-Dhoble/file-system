package bank.reader;

import bank.model.BankTransaction;
import bank.utils.DateUtils;
import com.ctc.wstx.util.StringUtil;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TransactionReader {
    public List<BankTransaction> read(String inputPath) {
        try{
            CSVReader reader = new CSVReader(new FileReader(inputPath));
            List<String[]> strings = reader.readAll();
            strings.remove(0);
            List<BankTransaction> bankTransactions = convert(strings);
            return bankTransactions;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public List<BankTransaction> convert(List<String[]> data) {
//        return data.stream().map(row -> buildTransaction(row)).collect(Collectors.toList());

        //this code can be written as below
        return data.stream().map(row -> {
            try{
                return buildTransaction(row);
            }catch (Exception ex){
                System.err.println(ex.getMessage() + " while processing : row: " + row);
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());

        //working of :: operator is to pass the method reference to the stream
    }

    public BankTransaction buildTransaction(String[] row) throws Exception{
        return BankTransaction.builder()
                .transactionID(row[0])
                .customerID(row[1])
                .customerDOB(DateUtils.convertToDate(row[2]))
                .custGender(StringUtils.isEmpty(row[3]) ? 'N' : row[3].charAt(0))
                .custLocation(row[4])
                .custAccountBalance(StringUtils.isEmpty(row[5]) ? 0 : Double.valueOf(row[5]))
                .transactionDate(DateUtils.convertToDate(row[6]))
                .transactionTime(StringUtils.isEmpty(row[7]) ? 0 : Long.valueOf(row[7]))
                .transactionAmount(StringUtils.isEmpty(row[8]) ? 0 : Double.valueOf(row[8]))
                .build();
    }
}
// 60 70