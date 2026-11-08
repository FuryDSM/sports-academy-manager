package com.example.academy.model;

public interface Pricelist {

    /*-------Enrollment prices-----*/

    int athletePrice = 50;
    int professionalAthletePrice = 20;

    /*-----------------------------*/


    /*---Subscription Discounts---*/

    double level1and2Disc = 10.00/100;
    double level3and4Disc = 20.00/100;
    double level5Disc = 30.00/100;

    double bonusDisc = 20.00/100;       //bonus discount for professionals

    /*----------------------------*/


    double calculateTotalPrice();
}
