package domain;

import java.math.BigDecimal;

public class Convertor {

    private static final BigDecimal CENTIMETER_IN_AN_INCH = BigDecimal.valueOf(2.54);

    public BigDecimal inchesToCentimeters(BigDecimal inches) {
        return inches.multiply(CENTIMETER_IN_AN_INCH);
    }
}
