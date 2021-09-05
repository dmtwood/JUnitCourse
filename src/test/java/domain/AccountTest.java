package domain;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void beforeEach() {
        account = new Account();
    }

    @Test
    @DisplayName("Het saldo van een nieuwe rekening is 0 €.")
    void aNewAccountHasABalanceOfZero(){
        Assertions.
                assertThat(account.checkBalance())
//                .isEqualByComparingTo("0");
                .isZero();
    }


    @Test
    @DisplayName("Als je 10 € stort op een rekening is het saldo van de rekening 10 €.")
    void depositingTenOnANewAccountResultsInaBalanceOfTen() {
        account.deposit( BigDecimal.valueOf(10));
        Assertions
                .assertThat( account.checkBalance() )
                .isEqualByComparingTo("10");
    }

    @Test
    @DisplayName("Als je 10 € en daarna 1 € stort op een rekening is het saldo van de rekening 11 €.")
    void depositingFirstTenAndTHen1ResultsInABalanceOf11() {
        account.deposit(BigDecimal.valueOf(10));
        account.deposit(BigDecimal.ONE);
        Assertions
                .assertThat( account.checkBalance() )
                .isEqualByComparingTo("11");
    }


}