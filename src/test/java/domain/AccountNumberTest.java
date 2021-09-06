package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Checks wether an AccountNumber is valid in Belgium:
* starts with BE,
* has 14 digits,
* first two digits > 1 & < 99
* ( last 12 digits, append 1114, append first two digits ) % 97 = 1
 */
public class AccountNumberTest {



    @Test
    void BE72091012240116isACorrectBeAccount() {
        new AccountNumber("BE72091012240116");
    }

    @Test
    void notEnoughCharsThrowsException() {
        Assertions
                .assertThatIllegalArgumentException().isThrownBy(
                        () -> new AccountNumber("BE0000000"));
    }

    @Test
    void tooMuchCharsThrowsException() {
        Assertions
                .assertThatIllegalArgumentException().isThrownBy(
                        () -> new AccountNumber("BE12345678901234567890")
                );
    }

    @Test
    void aNonBePrefixThrowsAnException() {
        Assertions
                .assertThatIllegalArgumentException().isThrownBy(
                        () -> new AccountNumber("NL72091012240116")
                );
    }

    @Test
    void wrongCharsThrowAnException() {
        Assertions
                .assertThatIllegalArgumentException().isThrownBy(
                        () -> new AccountNumber("BEL20910122401_!")
                );
    }

    @Test
    void tooLowCheckNrThrowsException() {
        Assertions
                .assertThatIllegalArgumentException().isThrownBy(
                        () -> new AccountNumber("BE01091012240116")
                );
    }

    @Test
    void tooHighCheckNrThrowsException() {
        Assertions
                .assertThatIllegalArgumentException().isThrownBy(
                        () -> new AccountNumber("BE99091012240116")
                );
    }

    @Test
    void aWrongCheckCalculationThrowsAnException() {
        Assertions
                .assertThatIllegalArgumentException().isThrownBy(
                        () -> new AccountNumber("BE72091012240115")
                );
    }

    @Test
    void emptyThrowsAnException() {
        Assertions
                .assertThatIllegalArgumentException().isThrownBy(
                        () -> new AccountNumber(" ")
                );
    }

    @Test
    void nullThrowsAnNullPointerException() {
        Assertions
                .assertThatNullPointerException().isThrownBy(
                        () -> new AccountNumber(null)
                );
    }

    @Test
    void toStringShowsCorrectString() {
        Assertions
                .assertThat(new AccountNumber("BE72091012240116") )
                .hasToString("Rekeningnummer: BE72091012240116");
    }


}
