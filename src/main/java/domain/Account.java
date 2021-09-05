package domain;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    public void deposit(BigDecimal amountToDeposit) {
        balance = balance.add(amountToDeposit);
    }

    public BigDecimal checkBalance() {
        return balance;
    }
}
