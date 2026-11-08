package com.example.academy.ui;

import java.util.function.Supplier;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/** Navigation dashboard for the three original coursework workflows. */
public class MainSceneCreator extends SceneCreator {
    public MainSceneCreator(double width, double height) {
        super(width, height);
    }

    @Override
    Scene createScene() {
        Label eyebrow = new Label("SPORTS ACADEMY MANAGER");
        eyebrow.getStyleClass().add("eyebrow");
        Label title = new Label("Η ακαδημία, οργανωμένη.");
        title.getStyleClass().add("hero-title");
        Label description = new Label("Διαχειριστείτε αθλητές, συνδρομές και κρατήσεις από έναν χώρο.");
        description.getStyleClass().add("subtitle");
        description.setWrapText(true);
        GridPane navigation = new GridPane();
        navigation.setHgap(18);
        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / 3);
            navigation.getColumnConstraints().add(column);
        }
        navigation.add(card("01", "Αθλητές", "Εγγραφές, στοιχεία επικοινωνίας και πληρωμές.", () -> App.athleteScene), 0, 0);
        navigation.add(card("02", "Συνδρομές", "Προγράμματα, μηνιαίο κόστος και συμμετοχές.", () -> App.subscriptionScene), 1, 0);
        navigation.add(card("03", "Κρατήσεις", "Προπονήσεις, ιστορικό και ακυρώσεις.", () -> App.reservationScene), 2, 0);
        Label note = new Label("Εκπαιδευτική εφαρμογή • Τα δεδομένα διατηρούνται μόνο όσο η εφαρμογή είναι ανοικτή.");
        note.getStyleClass().add("subtitle");
        note.setWrapText(true);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        VBox root = new VBox(22, eyebrow, title, description, navigation, spacer, note);
        root.setPadding(new Insets(54, 48, 34, 48));
        root.setAlignment(Pos.TOP_LEFT);
        return ViewStyle.scene(root, width, height);
    }

    private Button card(String number, String title, String description, Supplier<Scene> destination) {
        Label step = new Label(number);
        step.getStyleClass().add("card-number");
        Label heading = new Label(title);
        heading.getStyleClass().add("card-title");
        Label detail = new Label(description);
        detail.getStyleClass().add("card-description");
        detail.setWrapText(true);
        VBox content = new VBox(14, step, heading, detail);
        content.setAlignment(Pos.TOP_LEFT);
        content.setMouseTransparent(true);
        Button button = new Button();
        button.setGraphic(content);
        button.setAccessibleText(title);
        button.getStyleClass().add("navigation-card");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setPrefHeight(210);
        button.setOnAction(event -> {
            App.primaryStage.setScene(destination.get());
            App.primaryStage.setTitle(title + " | Sports Academy Manager");
        });
        return button;
    }
}
