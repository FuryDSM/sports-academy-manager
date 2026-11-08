package com.example.academy.ui;

import static org.junit.jupiter.api.Assertions.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class DateRulesTest {
    @Test void acceptsLeapDay() {
        assertEquals(LocalDate.of(2024, 2, 29), DateRules.parse("29/02/2024"));
    }

    @Test void rejectsNonexistentCalendarDates() {
        for (String date : new String[]{"29/02/2023", "31/04/2024", "00/12/2024", "01/13/2024"}) {
            assertThrows(DateTimeException.class, () -> DateRules.parse(date));
        }
    }

    @Test void requiresTheDocumentedFormat() {
        for (String date : new String[]{"1/2/2024", "2024-02-01", "", " 01/02/2024 "}) {
            assertThrows(IllegalArgumentException.class, () -> DateRules.parse(date));
        }
        assertThrows(IllegalArgumentException.class, () -> DateRules.parse(null));
    }

    @Test void ordersDatesAcrossMonthAndYearBoundaries() {
        assertTrue(DateRules.isOnOrBefore("31/12/2024", "01/01/2025"));
        assertTrue(DateRules.isOnOrBefore("28/02/2024", "01/03/2024"));
        assertTrue(DateRules.isOnOrBefore("01/03/2024", "01/03/2024"));
        assertFalse(DateRules.isOnOrBefore("02/03/2024", "01/03/2024"));
    }

    @Test void cancellationRequiresAtLeastThePreviousCalendarDay() {
        assertTrue(DateRules.canCancel("31/12/2024", "01/01/2025"));
        assertTrue(DateRules.canCancel("28/02/2024", "29/02/2024"));
        assertFalse(DateRules.canCancel("01/01/2025", "01/01/2025"));
        assertFalse(DateRules.canCancel("02/01/2025", "01/01/2025"));
    }
}
