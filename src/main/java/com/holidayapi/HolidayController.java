package com.holidayapi;

import com.holidayapi.Model.Holiday;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class HolidayController {
    private HashSet<HashSet<Holiday>> years;
}
