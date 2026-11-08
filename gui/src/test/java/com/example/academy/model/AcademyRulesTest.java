package com.example.academy.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AcademyRulesTest {
    private Athlete athlete(boolean professional, int experience, char gender) {
        return new Athlete(100, "Example", "Athlete", gender, "01/01/2000",
                "athlete@example.com", professional, experience);
    }

    @Test void enrollmentUsesTheCourseworkPriceList() {
        assertEquals(50.0, new Enrollment(1, athlete(false, 3, 'Α'), "01/01/2024", 0, 0).calculateTotalPrice());
        assertEquals(20.0, new Enrollment(2, athlete(true, 3, 'Α'), "01/01/2024", 0, 0).calculateTotalPrice());
    }

    @Test void subscriptionAppliesExperienceDiscounts() {
        double[] expected = {45, 45, 40, 40, 35};
        for (int level = 1; level <= 5; level++) {
            Subscription subscription = new Subscription("example", athlete(false, level, 'Α'), null, 0);
            assertEquals(expected[level - 1], subscription.calculateTotalPrice(), 0.001);
        }
    }

    @Test void professionalBonusIsAppliedAfterExperienceDiscount() {
        assertEquals(11.2, new Subscription("example", athlete(true, 5, 'Α'), null, 0).calculateTotalPrice(), 0.001);
    }

    @Test void mixedProgramsAcceptBothCourseworkGenderValues() {
        TrainingProgram mixed = new TrainingProgram(1, null, null, null, 1, true, 'Μ', 60, "Monday");
        assertTrue(mixed.checkRequiredGender(athlete(false, 3, 'Α')));
        assertTrue(mixed.checkRequiredGender(athlete(false, 3, 'Γ')));
    }

    @Test void singleGenderProgramsCheckEligibility() {
        TrainingProgram program = new TrainingProgram(1, null, null, null, 1, true, 'Γ', 60, "Monday");
        assertTrue(program.checkRequiredGender(athlete(false, 3, 'Γ')));
        assertFalse(program.checkRequiredGender(athlete(false, 3, 'Α')));
    }

    @Test void reservationIdentityIncludesAthleteProgramAndDate() {
        String first = TrainingProgramReservation.generateTrainingProgramReservationID(1, 2, "01/01/2024");
        assertEquals(first, TrainingProgramReservation.generateTrainingProgramReservationID(1, 2, "01/01/2024"));
        assertNotEquals(first, TrainingProgramReservation.generateTrainingProgramReservationID(1, 2, "02/01/2024"));
        assertNotEquals(first, TrainingProgramReservation.generateTrainingProgramReservationID(2, 2, "01/01/2024"));
    }
}
