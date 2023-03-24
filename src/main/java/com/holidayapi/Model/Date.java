package com.holidayapi.Model;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class Date {
    @Getter
    private int day;
    @Getter
    private int month;
    @Getter
    private int year;
    private boolean isHoliday;

    public Date(@NotNull String dateString) throws IllegalArgumentException {
        if(!dateString.matches("\\d{4}-\\d{2}-\\d{2}"))
            throw new IllegalArgumentException("Given String " + dateString + " does not represent a date!");
        year = Integer.parseInt(dateString.substring(0, 4));
        month = Integer.parseInt(dateString.substring(5, 7));
        day = Integer.parseInt(dateString.substring(8, 10));
        if(!isValidDate(year, month, day))
            throw new IllegalArgumentException("Given String " + dateString + " represents an invalid date!");
    }

    public static boolean isValidDate(int year, int month, int day) {
        if(
            year < 0 ||
            month < 1 || month > 12 ||
            day < 1 || day > 31 ||
            (month < 8 && month % 2 == 0 || month > 7 && month % 2 != 0) && day > 30 ||
            month == 2 && day > 29 ||
            year % 4 != 0 && month == 2 && day > 28
        ) return false;
        return true;
    }

    public boolean isBefore(@NotNull Date other) {
        if(this.year > other.getYear()) return false;
        if(this.year < other.getYear()) return true;
        if(this.month > other.getMonth()) return false;
        if(this.month < other.getMonth()) return true;
        if(this.day > other.getDay()) return false;
        if(this.day < other.getDay()) return true;
        return false;
    }

    public boolean isAfter(@NotNull Date other) {
        if(this.year < other.getYear()) return false;
        if(this.year > other.getYear()) return true;
        if(this.month < other.getMonth()) return false;
        if(this.month > other.getMonth()) return true;
        if(this.day < other.getDay()) return false;
        if(this.day > other.getDay()) return true;
        return false;
    }

    public boolean equals(@NotNull Date other) {
        return this.year == other.getYear() &&
                this.month == other.getMonth() &&
                this.day == other.getDay();
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
