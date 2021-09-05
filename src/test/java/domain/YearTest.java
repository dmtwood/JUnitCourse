package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YearTest {

    @Test
    @DisplayName("A year dividable by 400 is a leapyear")
    void dividableBy400IsALeapYear() {
        Year year = new Year(4000);
        Assertions.assertThat(year.isLeapYear());
    }

    @Test
    void dividableBy100IsNotALeapYear(){
        Year year = new Year(100);
        Assertions.assertThat(year.isLeapYear() ).isFalse();
    }

    @Test
    void dividableBy4IsALeapYear() {
        Year year = new Year(2020);
        Assertions.assertThat(year.isLeapYear());
    }

    @Test
    void notDividableBy4IsNoLeapYaer() {
    Year year = new Year(2021);
    Assertions.assertThat(!year.isLeapYear());
    }

    @Test
    void toStringShowsCorrectString(){
        Year year = new Year(2000);
        Assertions.assertThat(year).hasToString("Year: 2000");
    }
}
