package com.example.academy.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import com.example.academy.model.Athlete;
import com.example.academy.model.Payment;
import com.example.academy.model.Subscription;
import com.example.academy.model.TrainingProgram;
import javafx.scene.Scene;
import javafx.scene.control.Alert;


public abstract class SceneCreator {


    //Data that needs to be shared between scenes

    //List of Athletes who have paid
    private static ArrayList<Athlete> athletesListPaid = new ArrayList<>();
    //List of Payments
    private static ArrayList<Payment> paymentsList = new ArrayList<>();
    //List of Training Programs
    private static ArrayList<TrainingProgram> trainingProgramsList = new ArrayList<>();
    //List of Subscriptions
    private static ArrayList<Subscription> subscriptionsList = new ArrayList<>();

    /*-----------------------------------------------*/

    double width;
    double height;

    public SceneCreator(double width, double height) {
        this.width = width;
        this.height = height;
    }

    abstract Scene createScene();


    //method that checks if the date the user entered is of pattern "dd/MM/yyyy"
    public static boolean isValidDate(String date) {

        try {

            DateRules.parse(date);
            return true;
        } catch (java.time.DateTimeException | IllegalArgumentException e) {

             Alert alertType = new Alert(Alert.AlertType.WARNING);
             alertType.setTitle("Μη έγκυρη ημερομηνία");
             alertType.setContentText("Χρησιμοποιήστε πραγματική ημερομηνία στη μορφή dd/MM/yyyy.");
             alertType.show();
             return false;
        }
    }

    public static void addToAthletesListPaid(Athlete athlete) {  //adds athlete to list

         athletesListPaid.add(athlete);
    }

    public static void addToPaymentsList(Payment payment) {  //adds payment to list

        paymentsList.add(payment);
    }

    public static void addToTrainingProgramsList(TrainingProgram trainingProgram) {  //adds training program to list

        trainingProgramsList.add(trainingProgram);
    }

    public static void addToSubscriptionsList(Subscription subscription) {  //adds subscription to list

        subscriptionsList.add(subscription);
    }

public static void removeFromSubscriptionsList(int i) {  //removes an item from the subscriptions List

        subscriptionsList.remove(i);
    }

    public static ArrayList<Athlete> getAthletesListPaid() {  //getters

        return athletesListPaid;
    }

    public static ArrayList<Payment> getPaymentsList() {

        return paymentsList;
    }

    public static ArrayList<TrainingProgram> getTrainingProgramsList() {

        return trainingProgramsList;
    }

    public static ArrayList<Subscription> getSubscriptionsList() {

        return subscriptionsList;
    }
}
