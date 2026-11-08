package com.example.academy.model;

public abstract class User {

    private static int userCounter = 0;

    private int uniqueID;
    private String name;
    private String lastName;
    private char gender;  // 'Α' for male 'Γ' for female
    private String dateOfBirth;
    private String contactInfo;


    User(int uniqueID, String name, String lastName, char gender, String dateOfBirth, String contactInfo) {

            this.setUniqueID(uniqueID);
            this.setName(name);
            this.setLastName(lastName);
            this.setGender(gender);
            this.setDateOfBirth(dateOfBirth);
            this.setContactInfo(contactInfo);
    }

    public static int generateUserUniqueId() {

        userCounter++;

        return userCounter;
    }


    public int getUniqueID() {  //getters and setters

        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {

        this.uniqueID = uniqueID;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }


    public char getGender() {

        return gender;
    }

    public void setGender(char gender) {

        this.gender = gender;
    }


    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }


    public String getContactInfo() {

        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {

        this.contactInfo = contactInfo;
    }
}
