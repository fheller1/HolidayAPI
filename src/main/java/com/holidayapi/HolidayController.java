package com.holidayapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidayController {
    @GetMapping("/date")
    public String todayDate() {
        return java.time.LocalDate.now().toString();
    }
}
