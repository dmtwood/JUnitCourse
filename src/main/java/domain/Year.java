package domain;

import java.util.Objects;

public class Year {
    private final int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isLeapYear() {
//        if (year % 400 == 0 ) return true;
//        if (year % 100 == 0 ) return false;
//        return year % 4 == 0;
        return year % 4 == 0 && year % 100 != 0 ||  year % 400 == 0;
    }

    @Override
    public String toString() {
        return "Year: " + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Year)) return false;
        Year year1 = (Year) o;
        return year == year1.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }
}
