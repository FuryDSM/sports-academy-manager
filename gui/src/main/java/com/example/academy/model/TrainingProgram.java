package com.example.academy.model;

public class TrainingProgram {

    private static int TrainingProgramCounter = 0;

    private int uniqueID;
    private Sport sport;
    private Facility facility;
    private Coach coach;

    private int minRequiredExp;  //minimum experience required by athletes to subscribe in the program
    private boolean reservWeeklyReq;  //reservation weekly required
    private char gender;  // 'Α' for male 'Γ' for female 'Μ' for mixed
    private int durationMin;  //duration in minutes
    private String day;  //represents the day of the week the training program takes place (example: Monday)

    public TrainingProgram(int uniqueID, Sport sport, Facility facility, Coach coach, int minimumExp, boolean reservWeeklyReq, char gender, int durationMin, String day) {

        this.setUniqueID(uniqueID);
        this.setSport(sport);
        this.setCoach(coach);
        this.setFacility(facility);
        this.setMinRequiredExp(minimumExp);
        this.setReservWeeklyReq(reservWeeklyReq);
        this.setRequiredGender(gender);
        this.setDurationMin(durationMin);
        this.setDay(day);
    }

    public static int generateTrainingProgramUniqueId() {

        TrainingProgramCounter++;

        return TrainingProgramCounter;
    }

    public boolean checkRequiredGender(Athlete athlete) {  		//checks if athlete can participate in the training program depending
                                                                //on the required gender of the program (male female or mixed)
        if(this.getRequiredGender() == 'Μ') {  //both genders allowed

            return true;
        }
        else if(this.getRequiredGender() == athlete.getGender()) {

            return true;
        }
        else {

            return false;
        }
    }


    public int getUniqueID() {  //getters and setters

        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {

        this.uniqueID = uniqueID;
    }

    public Sport getSport() {

        return sport;
    }

    public void setSport(Sport sport) {

        this.sport = sport;
    }


    public Facility getFacility() {

        return facility;
    }

    public void setFacility(Facility facility) {

        this.facility = facility;
    }


    public Coach getCoach() {

        return coach;
    }

    public void setCoach(Coach coach) {

        this.coach = coach;
    }


    public int getMinRequiredExp() {

        return minRequiredExp;
    }

    public void setMinRequiredExp(int minimumExp) {

        this.minRequiredExp = minimumExp;
    }


    public boolean getReservWeeklyReq() {

        return reservWeeklyReq;
    }

    public void setReservWeeklyReq(boolean reservWeeklyReq) {

        this.reservWeeklyReq = reservWeeklyReq;
    }


    public char getRequiredGender() {

        return gender;
    }

    public void setRequiredGender(char gender) {

        this.gender = gender;
    }

    public int getDurationMin() {

        return durationMin;
    }

    public void setDurationMin(int durationMin) {

        this.durationMin = durationMin;
    }

    public String getDay() {

        return day;
    }

    public void setDay(String day) {

        this.day = day;
    }
}
