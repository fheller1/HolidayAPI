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

    @GetMapping("/date")
    public String todayDate() {
        return java.time.LocalDate.now().toString();
    }
}
