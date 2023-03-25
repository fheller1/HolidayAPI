package com.holidayapi;

import com.holidayapi.Model.Date;
import com.holidayapi.Model.Holiday;
import com.holidayapi.Model.germanStateEnum.germanState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HolidayController {

    @GetMapping("/getFixed")
    private static List<Holiday> getFixedHolidays(@RequestParam Integer year) {
        ArrayList<Holiday> holidays = new ArrayList<>();
        holidays.add(new Holiday(
                new Date(year, 1, 1),
                "Neujahr",
                List.of(),
                true
        ));
        holidays.add(new Holiday(
                new Date(year, 1, 1),
                "Heilige Drei Könige",
                List.of(germanState.BY, germanState.BW, germanState.SH),
                false
        ));
        holidays.add(new Holiday(
                new Date(year, 3, 8),
                "Internationaler Frauentag",
                List.of(germanState.BE, germanState.MV),
                false
        ));
        holidays.add(new Holiday(
                new Date(year, 5, 1),
                "Tag der Arbeit",
                List.of(),
                true
        ));
        holidays.add(new Holiday(
                new Date(year, 8, 15),
                "Mariä Himmelfahrt",
                List.of(germanState.SL),
                false
        ));
        holidays.add(new Holiday(
                new Date(year, 9, 20),
                "Weltkindertag",
                List.of(germanState.TH),
                false
        ));
        holidays.add(new Holiday(
                new Date(year, 10, 3),
                "Tag der deutschen Einheit",
                List.of(),
                true
        ));
        holidays.add(new Holiday(
                new Date(year, 10, 31),
                "Reformationstag",
                List.of(germanState.BB, germanState.HB, germanState.HH, germanState.MV, germanState.NI, germanState.SN, germanState.ST, germanState.SH, germanState.TH),
                false
        ));
        holidays.add(new Holiday(
                new Date(year, 11, 1),
                "Allerheiligen",
                List.of(germanState.BW, germanState.BY, germanState.NW, germanState.RP, germanState.SL),
                false
        ));
        holidays.add(new Holiday(
                new Date(year, 12, 25),
                "1. Weihnachtsfeiertag",
                List.of(),
                true
        ));
        holidays.add(new Holiday(
                new Date(year, 12, 26),
                "2. Weihnachtsfeiertag",
                List.of(),
                true
        ));
        return holidays;
    }

    /**
     * This method implements the Gauss' Easter formula and returns the date of Easter sunday in the given year
     * @param year year to determine Easter sunday's date for
     * @return Date object of Easter sunday in the given year
     */
    @GetMapping("/getEasterSunday")
    private static Date getEasterSunday(@RequestParam Integer year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int M = (15 + k - p - q) % 30;
        int d = (19 * a + M) % 30;
        int N = (4 + k - q) % 7;
        int e = (2 * b + 4 * c + 6 * d + N) % 7;
        int easterDay = 22 + d + e;
        if(d == 29 && e == 6) easterDay = 50;
        if(d == 28 && e == 6 && a > 10) easterDay = 49;
        return easterDay < 32
                ? new Date(year, 3, easterDay)
                : new Date(year, 4, easterDay - 31);
    }

    @GetMapping("/date")
    private String todayDate() {
        return java.time.LocalDate.now().toString();
    }
}
