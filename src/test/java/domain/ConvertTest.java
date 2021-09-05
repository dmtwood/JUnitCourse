package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ConvertTest {

    @Test
    @DisplayName("1 inch equals 2.54 cm")
    void oneInchIs2Point54Centimeters() {
        Convertor convertor = new Convertor();
        Assertions
                .assertThat( convertor.inchesToCentimeters( BigDecimal.ONE ) )
//                .isEqualByComparingTo (BigDecimal.valueOf(2.54) );
                // assertJ converts string to BigDecimal
                .isEqualByComparingTo("2.54");
    }

    @Test
    @DisplayName("100 inch equals 254 cm")
    void hundredInchesAreIs254Centimeters() {
        Convertor convertor = new Convertor();
        Assertions
                .assertThat( convertor.inchesToCentimeters( BigDecimal.valueOf(100) ) )
//                .isEqualByComparingTo (BigDecimal.valueOf(254) );
                // assertJ converts string to BigDecimal
                .isEqualByComparingTo("254");
    }

}
