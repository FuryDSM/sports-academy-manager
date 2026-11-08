package com.example.academy.model;

public class TrainingProgramReservation {

    private String uniqueID;
    private Athlete athlete;
    private TrainingProgram trainingProgram;
    private String trainingProgramDate;

    public TrainingProgramReservation(String uniqueID,Athlete athlete, TrainingProgram trainingProgram, String trainingProgramDate) {

        this.setUniqueID(uniqueID);
        this.setAthlete(athlete);
        this.setTrainingProgram(trainingProgram);
        this.setTrainingProgramDate(trainingProgramDate);
    }

    public static String generateTrainingProgramReservationID(int athleteID, int trainingProgramID, String trainingProgramDate) {


        return "<" + String.valueOf(athleteID) + "_" + String.valueOf(trainingProgramID)  //generate unique id based on athleteID, trainingProgramID and
           + "_" + trainingProgramDate + ">";  																				   //and trainingProgramDate
    }


    public String getUniqueID() {  //getters and setters

        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {

        this.uniqueID = uniqueID;
    }
    public Athlete getAthlete() {

        return athlete;
    }

    public void setAthlete(Athlete athlete) {

        this.athlete = athlete;
    }


    public TrainingProgram trainingProgram() {

        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {

        this.trainingProgram = trainingProgram;
    }


    public String trainingProgramDate() {

        return trainingProgramDate;
    }

    public void setTrainingProgramDate(String trainingProgramDate) {

        this.trainingProgramDate = trainingProgramDate;
    }
}
