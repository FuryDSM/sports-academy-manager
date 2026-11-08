package com.example.academy.model;

public class ReservationData {

    String reservationID;
        int athleteUniqueID;
        int trainingProgramUniqueID;
        String date;

        public ReservationData(String reservationID,Athlete athlete, TrainingProgram trainningProgram, String date) {

            this.reservationID = reservationID;
            this.athleteUniqueID = athlete.getUniqueID();
            this.trainingProgramUniqueID = trainningProgram.getUniqueID();
            this.date = date;

        }

        public String getReservationID() {
            return reservationID;
        }

        public int getAthleteUniqueID() {
            return athleteUniqueID;
        }
        public int getTrainingProgramUniqueID() {
            return trainingProgramUniqueID;
        }
        public String getDate() {
            return date;
        }

}
