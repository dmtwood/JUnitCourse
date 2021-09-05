package domain;

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
}
