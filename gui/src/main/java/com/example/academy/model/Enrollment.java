package com.example.academy.model;

public class Enrollment implements Pricelist {

    private int uniqueID;
    private Athlete athlete;
    private String date;
    private double price; //price is initialized to 0 and then is calculated based on whether the athlete is professional or not
    private double discount; //athlete's discount percentage

    public Enrollment(int uniqueID, Athlete athlete, String date, double price, double discount) {

        setUniqueId(uniqueID);  //uses athlete's ID
        setAthlete(athlete);
        setDate(date);
        setPrice(price);
        setDiscount(discount);
    }


    public double calculateTotalPrice()  //calculate enrollment's price
    {
        if(athlete.getProfessional() == true) {  //return the appropriate price of the enrollment based on whether the athlete is a professional or not

            this.setPrice( (double) professionalAthletePrice);

            return price;
        }
        else {

            this.setPrice( (double) athletePrice);

            return price;
        }
    }

    public static double calculateDiscount(boolean professional, int experience) {

        //calculate sale
        double baseSale;

        if(experience <= 2) {

            baseSale = level1and2Disc;
        }
        else if (experience <= 4) {

            baseSale = level3and4Disc;
        }
        else {

            baseSale = level5Disc;
        }


        if(professional == true) {

            return baseSale + bonusDisc;
        }
        else {

            return baseSale;
        }
    }

    public int getUniqueId() {  //getters and setters

        return uniqueID;
    }

    public void setUniqueId(int uniqueID) {

      this.uniqueID = uniqueID;
    }


    public Athlete getAthlete() {

        return athlete;
    }

    public void setAthlete(Athlete athlete) {

        this.athlete = athlete;
    }


    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }


    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }


    public double getDiscount() {

        return discount;
    }

    public void setDiscount(double discount) {

        this.discount = discount;
    }
}
