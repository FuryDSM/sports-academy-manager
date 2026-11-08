package com.example.academy.model;

public class Coach extends User {


    private Sport sport;
    private String diplomas;


    public Coach(int uniqueID, String name, String lastName, char gender, String dateOfBirth, String contactInfo, Sport sport, String diplomas) {

        super(uniqueID, name, lastName, gender, dateOfBirth, contactInfo);

        this.setDiplomas(diplomas);
        this.setSport(sport);
    }


    public Sport getSport() {  //getters and setters

        return sport;
    }
    public void setSport(Sport sport) {

        this.sport = sport;
    }


    public String getDiplomas() {

        return diplomas;
    }
    public void setDiplomas(String diplomas) {

        this.diplomas = diplomas;
    }
}
