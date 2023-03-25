package com.holidayapi.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * An Object of the class <code>Holiday</code> represents a single occurrence of a holiday, including its name,
 * information about states that honor this holiday, and a <code>boolean</code> true if all German states honor it.
 */
@Data
@Builder
@AllArgsConstructor
public class Holiday {
    private Date date;
    private String name;
    private List<germanStateEnum.germanState> states;
    private Boolean isGlobalHoliday;
}
