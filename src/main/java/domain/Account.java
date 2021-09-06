package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private List<BigDecimal> deposits;

    public Account() {
        this.deposits = new ArrayList<>();
    }


    public void deposit( BigDecimal amountToDeposit ) {
       if ( amountToDeposit.compareTo( BigDecimal.ZERO ) <= 0 ) {
            throw new IllegalArgumentException("Te storten bedrag moet positief zijn.");
        }
        balance = balance.add( amountToDeposit );
       deposits.add( amountToDeposit );
    }


    public BigDecimal checkBalance() {
        return balance;
    }


    // returns a list of all deposits
    public List<BigDecimal> getDeposits() {
        return deposits;
    }


    // returns a list of all deposits, sorted ascending
    public List<BigDecimal> getDepositsSorted() {
        return deposits.stream().sorted().collect(Collectors.toList());
    }

}
