package com.holidayapi.Model;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

enum germanState {
    BY,
    BW,
    HE,
    TH,
    RP,
    SL,
    NW,
    NI,
    HB,
    HH,
    SH,
    MV,
    BE,
    BB,
    ST,
    SN
}

/**
 * An Object of the class <code>Holiday</code> represents a single occurrence of a holiday, including its name,
 * information about states that honor this holiday, and a <code>boolean</code> if all German states honor it.
 */
public class Holiday extends Date{
    private String name;
    private List<germanState> states;
    private Boolean isGlobalHoliday;

    public Holiday(@NotNull String dateString) throws IllegalArgumentException {
        super(dateString);
    }
}
