package domain;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    public void deposit(BigDecimal amountToDeposit) {
       if ( amountToDeposit.compareTo( BigDecimal.ZERO ) <= 0 ) {
            throw new IllegalArgumentException("Te storten bedrag moet positief zijn.");
        }
        balance = balance.add(amountToDeposit);
    }

    public BigDecimal checkBalance() {
        return balance;
    }
}
