package com.example.academy.model;

public class Subscription implements Pricelist {

    private static int SubscriptionCounter = 0;

    private String uniqueID;
    private Athlete athlete;
    private TrainingProgram trainingProgram;
    private double monthlyCost;  //monthly cost is initialized to 0 and then calculated properly (including the athlete's discount)

    public Subscription(String uniqueID, Athlete athlete, TrainingProgram trainingProgram, double monthlyCost) {

         setAthlete(athlete);
         setTrainingProgram(trainingProgram);
         setMonthlyCost(monthlyCost);
         setUniqueID(uniqueID);

         calculateTotalPrice();
    }

    public static String generateSubscriptionUniqueId(int athleteID, int trainingProgramID) {

        SubscriptionCounter++;

        return String.valueOf(athleteID) + "_" + String.valueOf(trainingProgramID)  //generate unique ID based on athleteID and trainingProgramID
                               + "_<" + String.valueOf(SubscriptionCounter) + ">";
    }

    @Override
    public double calculateTotalPrice() {  //calculate subscription's total price after the athlete's discounts

        double basePrice;  //initial price
        double totalPrice; //price after the applied discounts

        if ((athlete.getProfessional() == true)) { //determine base price based on whether the athlete is professional or not, then apply discounts to get final price

            basePrice = (double) professionalAthletePrice;
        }
        else {

            basePrice = (double) athletePrice;
        }

        if ((athlete.getExperience() <= 2)) {

            totalPrice =  basePrice - basePrice * level1and2Disc;
        }
        else if ((athlete.getExperience() <= 4)) {

            totalPrice = basePrice - basePrice * level3and4Disc;
        }
        else {

            totalPrice = basePrice - basePrice * level5Disc;
        }

        if ((athlete.getProfessional() == true)) {

         totalPrice -= totalPrice * bonusDisc;
        }

        this.monthlyCost = totalPrice;

        return monthlyCost;
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


    public TrainingProgram getTrainingProgram() {

        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {

        this.trainingProgram = trainingProgram;
    }


    public double getMonthlyCost() {

        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {

        this.monthlyCost = monthlyCost;
    }

    public static int getSubscriptionCounter() {

        return SubscriptionCounter;
    }

}
