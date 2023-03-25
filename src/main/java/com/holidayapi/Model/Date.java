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

    public Date(@NotNull String dateString) {
        if(!dateString.matches("\\d{4}-\\d{2}-\\d{2}"))
            throw new IllegalArgumentException("Given String " + dateString + " does not represent a date!");
        year = Integer.parseInt(dateString.substring(0, 4));
        month = Integer.parseInt(dateString.substring(5, 7));
        day = Integer.parseInt(dateString.substring(8, 10));
        if(!isValidDate(year, month, day))
            throw new IllegalArgumentException("Given String " + dateString + " represents an invalid date!");
    }

    public Date(int year, int month, int day) {
        if(!isValidDate(year, month, day))
            throw new IllegalArgumentException("Given Integers represent an invalid date!");
        this.year = year;
        this.month = month;
        this.day = day;
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

    /**
     * Calculates the date <code>days</code> days after <code>this</code>. Returns the calculated date and does not
     * change <code>this</code>.
     * @param days to add to <code>this</code>
     * @return new <code>Date</code> object <code>days</code> days in the future of <code>this</code>
     */
    public Date plusDays(int days) {
        int newYear = year;
        int newMonth = month;
        int newDay = day + days;
        while(newDay > daysInMonth(newYear, newMonth)) {
            newDay -= daysInMonth(newYear, newMonth);
            if(newMonth == 12) {
                newMonth = 1;
                newYear++;
            }
            else {
                newMonth++;
            }
        }
        return new Date(newYear, newMonth, newDay);
    }

    /**
     * Returns the number of days in a given month in a given year
     * @param year
     * @param month
     * @return days in the provided month
     */
    public static int daysInMonth(int year, int month) {
        if(month == 2) return year % 4 == 0 ? 29 : 28;
        if(month < 8 && month % 2 == 1 || month > 7 && month % 2 == 0) return 31;
        return 30;
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

    @Override
    public boolean equals(Object object) {
        if(object.getClass() != Date.class) return false;
        Date other = (Date) object;
        return this.year == other.getYear() &&
                this.month == other.getMonth() &&
                this.day == other.getDay();
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
