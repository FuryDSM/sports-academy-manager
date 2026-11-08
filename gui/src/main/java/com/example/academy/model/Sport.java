package com.example.academy.model;

public class Sport {


    private String name;
    private boolean Professional;


    public Sport(String name, boolean Professional) {

        this.setName(name);
        this.setProfessional(Professional);

    }


    public String getName() {  //getters and setters

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }

    public boolean isProfessional() {

        return Professional;
    }
    public void setProfessional(boolean Professional) {

        this.Professional = Professional;
    }
}
