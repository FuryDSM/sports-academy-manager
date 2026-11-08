package com.example.academy.model;

public class Payment implements Pricelist {

    private static int paymentCounter = 0;

    private int uniqueID;
    private String date;
    private String paymentMethod;  //example: card or cash
    private Subscription subscription;  //user either pays for subscription or athlete enrollment
    private Enrollment enrollment;
    private double totalPrice; //is initialized to 0 and then is properly calculated

    //Subscription constructor
    public Payment(int uniqueID, String date, String paymentMethod,Subscription subscription, double totalPrice) {

        setUniqueID(uniqueID);
        setDate(date);
        setPaymentMethod(paymentMethod);
        setSubscription(subscription);
        setTotalPrice(totalPrice);
    }

    //Athlete Enrollment constructor
    public Payment(int uniqueID,String date, String paymentMethod, Enrollment enrollment, double totalPrice) {

        setUniqueID(uniqueID);
        setDate(date);
        setPaymentMethod(paymentMethod);
        setEnrollment(enrollment);
        setTotalPrice(totalPrice);
    }


    public static int generatePaymentUniqueID() {

        paymentCounter++;

        return paymentCounter;
    }

    @Override
    public double calculateTotalPrice() {  //calculate total price for either enrollment or subscription

        if(enrollment == null) {  //determine the Payment type (subscription or enrollment) and use the appropriate method

            return subscription.calculateTotalPrice();
        }
        else {

            return enrollment.calculateTotalPrice();
        }
    }


    public int getUniqueID() {  //getters and setters

        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {

        this.uniqueID = uniqueID;
    }


    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public Subscription getSubscription() {

        return subscription;
    }

    public void setSubscription(Subscription subscription) {

        this.subscription = subscription;
    }

    public Enrollment getEnrollment() {

        return enrollment;
    }

    private void setEnrollment(Enrollment enrollment) {

        this.enrollment = enrollment;
    }

    public String getPaymentMethod() {

        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {

        this.paymentMethod = paymentMethod;
    }

    public double getTotalPrice() {

        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {

        this.totalPrice = totalPrice;
    }
}
