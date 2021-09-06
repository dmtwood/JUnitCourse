package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    void avgOf0and10is5() {
        Assertions
                .assertThat(
                        Statistics.getAverage(
                                new BigDecimal[] { BigDecimal.ZERO, BigDecimal.TEN }
                        )
                ).isEqualByComparingTo(BigDecimal.valueOf(5));
    }

    @Test
    void avgOf1digitIsThatDigit() {
        Assertions
                .assertThat(Statistics.getAverage(
                        new BigDecimal[] {BigDecimal.ONE}
                )).isEqualByComparingTo(BigDecimal.valueOf(1));
    }

    @Test
    void avgOfAnEmptyArrayCantBeCalculated() {
        Assertions
                .assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> Statistics.getAverage(
                                new BigDecimal[] {}
                        )
                );
    }

    @Test
    void avgOfNullCantBeCalculated() {
        Assertions
                .assertThatNullPointerException().isThrownBy(
                        () -> Statistics.getAverage( null )
                );
    }

    @Test
    void avgOfAnArrayContainingNullCantBeCalculated() {
        Assertions
                .assertThatNullPointerException().isThrownBy(
                        () -> Statistics.getAverage(
                                new BigDecimal[] { BigDecimal.ONE, null}
                        )
                );
    }

}