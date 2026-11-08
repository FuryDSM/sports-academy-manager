package com.example.academy.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Entry point for the sports academy coursework application. */
public class App extends Application {
    static Stage primaryStage;
    static Scene mainScene, athleteScene, subscriptionScene, reservationScene;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setMinWidth(1024);
        primaryStage.setMinHeight(680);
        primaryStage.setResizable(true);
        mainScene = new MainSceneCreator(1220, 760).createScene();
        athleteScene = new AthleteSceneCreator(1220, 760).createScene();
        subscriptionScene = new SubscriptionSceneCreator(1220, 760).createScene();
        reservationScene = new ReservationSceneCreator(1220, 760).createScene();
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Sports Academy Manager");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
