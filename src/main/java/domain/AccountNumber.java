package domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

/*
 * an AccountNumber is valid in Belgium when it:
 * starts with BE,
 * has 14 digits,
 * first two digits > 1 & < 99
 * ( last 12 digits, append 1114, append first two digits ) % 97 = 1
 */
public class AccountNumber {
    // checks if starts with BE and has exactly 14 digits
    // In Java regex, a \ is represented by \\
    private static final Pattern REG_EX_BE_ACC_NR = Pattern.compile("BE\\d{14}$");
    private final String accountNumber;

    public AccountNumber(String accountNumber) {

        if ( ! REG_EX_BE_ACC_NR.matcher(accountNumber).matches() )
            throw new IllegalArgumentException("Verkeerd formaat. Begin met BE en geef dan 14 cijfers in.");

        long checkNr = Long.parseLong(accountNumber.substring(2, 4));
        if (checkNr < 2L || checkNr > 98L) {
           throw new IllegalArgumentException("Kijk je eerste twee cijfers na. (01 en 99 kunnen niet");
        }

        // you can also use Long.valueOf(String s) to convert a string to a long
       if( Long.parseLong(accountNumber.substring(4) + "1114" + checkNr) % 97 != 1 ) {
           throw new IllegalArgumentException("Verkeerd formaat. Kijk alle cijfers na.");
       }

       this.accountNumber = accountNumber;

    }



    @Override
    public String toString() {
        return "Rekeningnummer: " + accountNumber;
    }
}
