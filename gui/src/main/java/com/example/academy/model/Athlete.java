package com.example.academy.model;

public class Athlete extends User {


    private boolean professional;
    private int experience;


    public Athlete(int uniqueID, String name, String lastName, char gender, String dateOfBirth, String contactInfo, boolean professional, int experience) {

        super(uniqueID, name, lastName, gender, dateOfBirth, contactInfo);

        this.setProfessional(professional);
        this.setExperience(experience);
    }


    public boolean getProfessional() {  //getters and setters

        return professional;
    }
    public void setProfessional(boolean professional) {

        this.professional = professional;
    }


    public int getExperience() {

        return experience;
    }
    public void setExperience(int experience) {

        this.experience = experience;
    }


}
