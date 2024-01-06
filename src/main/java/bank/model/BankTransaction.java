package bank.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BankTransaction {
    private String transactionID;
    private String customerID;
    private Date customerDOB;
    private char custGender;
    private String custLocation;
    private double custAccountBalance;
    private Date transactionDate;
    private long transactionTime;
    private double transactionAmount;
}
