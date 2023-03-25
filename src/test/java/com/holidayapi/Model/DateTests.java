package com.holidayapi.Model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTests {
    Date d0;
    Date d1;
    Date d2;

    @Test
    void testInvalidCreation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date("Hello World");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date("2023-xx-01");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Date d = new Date("2023-13-32");
        });
    }

    @Test
    void testValidCreation() {
        d0 = new Date("2023-01-01");
        Assertions.assertEquals(1, d0.getDay());
        Assertions.assertEquals(1, d0.getMonth());
        Assertions.assertEquals(2023, d0.getYear());
        d1 = new Date("2023-07-31");
        Assertions.assertEquals(31, d1.getDay());
        Assertions.assertEquals(7, d1.getMonth());
        Assertions.assertEquals(2023, d1.getYear());
        d2 = new Date("2023-08-31");
        Assertions.assertEquals(31, d2.getDay());
        Assertions.assertEquals(8, d2.getMonth());
        Assertions.assertEquals(2023, d2.getYear());
    }

    @Test
    void testIsBefore() {
        d0 = new Date("2023-12-31");
        d1 = new Date("2024-01-01");
        Assertions.assertTrue(d0.isBefore(d1));
        Assertions.assertFalse(d1.isBefore(d0));
        Assertions.assertFalse(d0.isBefore(d0));
    }

    @Test
    void testIsAfter() {
        d0 = new Date("2023-12-31");
        d1 = new Date("2024-01-01");
        Assertions.assertFalse(d0.isAfter(d1));
        Assertions.assertTrue(d1.isAfter(d0));
        Assertions.assertFalse(d0.isAfter(d0));
    }

    @Test
    void testDaysInMonth() {
        Assertions.assertEquals(31, Date.daysInMonth(2023, 3));
        Assertions.assertEquals(31, Date.daysInMonth(2023, 12));
        Assertions.assertEquals(30, Date.daysInMonth(2023, 6));
        Assertions.assertEquals(30, Date.daysInMonth(2023, 9));
        Assertions.assertEquals(28, Date.daysInMonth(2023, 2));
        Assertions.assertEquals(29, Date.daysInMonth(2024, 2));
    }

    @Test
    void testPlusDays() {
        d0 = new Date("2023-03-25");
        Assertions.assertEquals(new Date("2023-03-26"), d0.plusDays(1));
        Assertions.assertEquals(new Date("2023-04-01"), d0.plusDays(7));
    }
}
