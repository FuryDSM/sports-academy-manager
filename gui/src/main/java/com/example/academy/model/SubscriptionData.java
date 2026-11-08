package com.example.academy.model;

public class SubscriptionData {

    private String subscriptionUniqueID;
    private int athleteUniqueID;
    private int trainingProgramUniqueID;
    private double monthlyCost;

    public SubscriptionData(Subscription subscription) {

        setSubscriptionUniqueID(subscription.getUniqueID());
        setAthleteUniqueID(subscription.getAthlete().getUniqueID());
        setTrainingProgramUniqueID(subscription.getTrainingProgram().getUniqueID());
        setMonthlyCost(subscription.getMonthlyCost());
    }

    public String getSubscriptionUniqueID() {  //getters and setters

        return subscriptionUniqueID;
    }

    public void setSubscriptionUniqueID(String subscriptionUniqueID) {

        this.subscriptionUniqueID = subscriptionUniqueID;
    }

    public int getAthleteUniqueID() {

        return athleteUniqueID;
    }

    public void setAthleteUniqueID(int athleteUniqueID) {

        this.athleteUniqueID = athleteUniqueID;
    }

    public int getTrainingProgramUniqueID() {

        return trainingProgramUniqueID;
    }

    public void setTrainingProgramUniqueID(int trainingProgramUniqueID) {

        this.trainingProgramUniqueID = trainingProgramUniqueID;
    }

    public double getMonthlyCost() {

        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {

        this.monthlyCost = monthlyCost;
    }
}
