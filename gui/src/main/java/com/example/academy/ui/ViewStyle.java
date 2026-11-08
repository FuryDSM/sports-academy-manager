package com.example.academy.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/** Shared desktop layout; business rules remain in the coursework classes. */
final class ViewStyle {
    private ViewStyle() { }

    static Scene scene(Parent root, double width, double height) {
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(ViewStyle.class.getResource("academy.css").toExternalForm());
        return scene;
    }

    static Scene workspace(String title, String description, GridPane previousRoot,
                           TableView<?> table, GridPane form, FlowPane actions, Button back) {
        previousRoot.getChildren().clear();
        table.setVisible(true);
        table.setPlaceholder(new Label("Δεν υπάρχουν ακόμη καταχωρήσεις."));
        table.setMinWidth(420);
        table.setPrefHeight(470);
        table.getColumns().forEach(column -> column.setMinWidth(100));
        form.setAlignment(Pos.TOP_LEFT);
        form.setHgap(12);
        form.setVgap(12);
        compactHiddenFields(form);

        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("page-title");
        Label subtitle = new Label(description);
        subtitle.getStyleClass().add("subtitle");
        subtitle.setWrapText(true);
        VBox heading = new VBox(6, titleLabel, subtitle);
        HBox.setHgrow(heading, Priority.ALWAYS);
        back.setText("← Αρχική");
        back.getStyleClass().add("secondary-button");
        HBox header = new HBox(24, heading, back);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(26, 28, 22, 28));

        Label formTitle = new Label("Στοιχεία καταχώρησης");
        formTitle.getStyleClass().add("section-title");
        VBox formCard = new VBox(20, formTitle, form);
        formCard.getStyleClass().add("form-card");
        ScrollPane formScroll = new ScrollPane(formCard);
        formScroll.setFitToWidth(true);
        formScroll.setMinWidth(360);
        SplitPane content = new SplitPane(table, formScroll);
        content.setDividerPositions(0.60);
        BorderPane.setMargin(content, new Insets(0, 28, 0, 28));

        actions.setHgap(10);
        actions.setVgap(10);
        actions.setAlignment(Pos.CENTER_LEFT);
        actions.setPadding(new Insets(20, 28, 24, 28));
        BorderPane root = new BorderPane(content, header, null, actions, null);
        return scene(root, 1220, 760);
    }

    private static void compactHiddenFields(Parent parent) {
        for (Node child : parent.getChildrenUnmodifiable()) {
            child.managedProperty().bind(child.visibleProperty());
            if (child instanceof TextField field) {
                field.setPrefColumnCount(15);
            }
            if (child instanceof Parent nested) {
                compactHiddenFields(nested);
            }
        }
    }
}
