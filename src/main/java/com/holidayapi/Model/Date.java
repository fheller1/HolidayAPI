package com.holidayapi.Model;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class Date {
    private int day;
    private int month;
    private int year;
    private boolean isHoliday;

    public Date(@NotNull String dateString) throws IllegalArgumentException {
        if(!dateString.matches("/[0-9]{4}-[0-9]{2}-[0-9]{2}/"))
            throw new IllegalArgumentException("Given String does not represent a date!");
        year = Integer.parseInt(dateString.substring(0,3));
        month = Integer.parseInt(dateString.substring(5, 6));
        day = Integer.parseInt(dateString.substring(8,9));
        if(!isValidDate(year, month, day))
            throw new IllegalArgumentException("Given String represents an invalid date!");
    }

    public static boolean isValidDate(int year, int month, int day) {
        if(
            year < 0 ||
            month < 1 || month > 12 ||
            day < 1 || day > 31 ||
            month % 2 == 0 && day > 30 ||
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
