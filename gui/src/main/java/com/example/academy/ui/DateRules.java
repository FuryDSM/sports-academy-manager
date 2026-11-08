package com.example.academy.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/** Calendar rules shared by forms and reservation filters. */
public final class DateRules {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter
            .ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    private DateRules() { }

    public static LocalDate parse(String value) {
        if (value == null || !value.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("Use dd/MM/yyyy.");
        }
        return LocalDate.parse(value, FORMAT);
    }

    public static boolean isOnOrBefore(String first, String second) {
        return !parse(first).isAfter(parse(second));
    }

    public static boolean canCancel(String today, String reservationDate) {
        return parse(today).isBefore(parse(reservationDate));
    }
}
