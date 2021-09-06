package domain;

import java.math.BigDecimal;
import java.util.Arrays;

public class Statistics {

    public Statistics() {
        throw new UnsupportedOperationException();
    }

    public static BigDecimal getAverage(BigDecimal[] numberArray) {

        if ( numberArray.length == 0 ) {
            throw new IllegalArgumentException("He gemiddelde van een lege array kan niet berekend worden.");
        }

        return
        Arrays.stream( numberArray )
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
//                      (subTotal, nextNumber) -> subTotal.add(nextNumber)
                        )
                .divide(
                        BigDecimal.valueOf(numberArray.length)
                );

    }

}
