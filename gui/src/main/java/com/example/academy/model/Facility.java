package com.example.academy.model;

public class Facility {


    private String facilityName;
    private int facilityCapacity;


    public Facility(String facilityName, int facilityCapacity) {

        this.setFacilityName(facilityName);
        this.setFacilityCapacity(facilityCapacity);
    }


    public String getFacilityName() {   //getters and setters

        return facilityName;
    }
    public void setFacilityName(String facilityName) {

        this.facilityName = facilityName;
    }


    public int getFacilityCapacity() {

        return facilityCapacity;
    }
    public void setFacilityCapacity(int facilityCapacity) {

        this.facilityCapacity = facilityCapacity;
    }
}
