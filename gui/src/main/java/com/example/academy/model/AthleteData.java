package com.example.academy.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class AthleteData {

    private int uniqueID;
    private String name;
    private String lastName;
    private char gender;
    private String dateOfBirth;
    private String contactInfo;
    private boolean professional;
    private int experience;
    private String date;
    private double totalPrice;

    public AthleteData(Athlete athlete, String date, double totalPrice){
         this.uniqueID = athlete.getUniqueID();
         this.name = athlete.getName();
         this.lastName = athlete.getLastName();
         this.gender = athlete.getGender();
         this.dateOfBirth = athlete.getDateOfBirth();
         this.contactInfo = athlete.getContactInfo();
         this.professional = athlete.getProfessional();
         this.experience = athlete.getExperience();
         this.date = date;
         this.totalPrice = totalPrice;
    }
    public int getUniqueID() {  //getters and setters

        return uniqueID;
    }


    public String getName() {

        return name;
    }


    public String getLastName() {

        return lastName;
    }


    public char getGender() {

        return gender;
    }

    public String getDateOfBirth() {

        return dateOfBirth;
    }


    public String getContactInfo() {

        return contactInfo;
    }

    public int getExperience() {

        return experience;
    }
    public boolean getProfessional() {

        return professional;
    }
    public String getDate() {

        return date;
    }
    public double  getTotalPrice() {

        return totalPrice;
    }
}
