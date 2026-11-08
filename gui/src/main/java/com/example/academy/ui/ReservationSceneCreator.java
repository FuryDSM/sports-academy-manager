package com.example.academy.ui;

import java.util.ArrayList;

import com.example.academy.model.Athlete;
import com.example.academy.model.ReservationData;
import com.example.academy.model.Subscription;
import com.example.academy.model.SubscriptionData;
import com.example.academy.model.TrainingProgram;
import com.example.academy.model.TrainingProgramReservation;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class ReservationSceneCreator extends SceneCreator implements EventHandler<ActionEvent> {

    //Flow panel
    FlowPane buttonFlowPane;
    //Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    //List of TrainingProgramReservations
    ArrayList<TrainingProgramReservation> TrainingProgramReservationsList;
    //List of Reservations
    ArrayList<ReservationData> ReservationsList;
    //List of Training Programs
    ArrayList<TrainingProgram> trainingProgramsList;
    //List of Athletes
    ArrayList<Athlete> athletesList;
    //Buttons
    Button newReservationBtn, showReservationListBtn, deleteReservationBtn, backBtn, futureBtn, pastBtn, athleteBtn, trainingBtn;
    //Labels
    Label reservationLbl, dateOfReservationLbl, athleteUniqueIDLbl, trainingProgramUniqueIDLbl, dateTodayLbl;
    //Field Fields
    TextField reservationFiled, dateOfReservationField, athleteUniqueIDField, trainingProgramUniqueIDField, dateTodayField;
    //Table view
    TableView<ReservationData>reservationTableView;


    public ReservationSceneCreator(double width, double height) {

        super(width, height);

        // Initialize the lists
        athletesList = new ArrayList<>();
        athletesList = SceneCreator.getAthletesListPaid();
        trainingProgramsList = new ArrayList<>();
        ReservationsList =  new ArrayList<>();
        TrainingProgramReservationsList = new ArrayList<>();

        // Initialize the FlowPane
        buttonFlowPane = new FlowPane();

        // Initialize the TableView
        reservationTableView = new TableView<>();

        // Initialize the GridPanes
        rootGridPane = new GridPane();
        inputFieldsPane = new GridPane();

        // Initialize the Labels
        reservationLbl = new Label ("Κωδικός Κράτησης: ");
        dateOfReservationLbl= new Label ("Ημερομηνία Κράτησης: ");
        athleteUniqueIDLbl= new Label ("Κωδικός Αθλητή: ");
        trainingProgramUniqueIDLbl= new Label ("Κωδικός Προγράμματος: ");
        dateTodayLbl = new Label("Σημερινή Ημερομηνία: ");
        dateTodayLbl.setVisible(false);

        // Initialize the Field Fields
        reservationFiled = new TextField();
        reservationFiled.setDisable(true);
        dateOfReservationField = new TextField();
        dateOfReservationField.setPromptText("dd/MM/yyyy");
        athleteUniqueIDField = new TextField();
        trainingProgramUniqueIDField = new TextField();
        dateTodayField = new TextField();
        dateTodayField.setPromptText("dd/MM/yyyy");
        dateTodayField.setVisible(false);
        dateTodayField.setEditable(false);

        // Initialize the Buttons
        newReservationBtn =  new Button("Καταχώριση νέας κράτησης");
        showReservationListBtn =  new Button("Εμφάνιση λίστας κρατήσεων");
        deleteReservationBtn =  new Button("Ακύρωση κράτησης.");
        backBtn =  new Button("Επιστροφή");
        futureBtn = new Button("Μελλοντικές Κρατήσεις");
        futureBtn.setDisable(true);
        futureBtn.setVisible(false);
        pastBtn = new Button ("Ιστορικό Κρατήσεων");
        pastBtn.setDisable(true);
        pastBtn.setVisible(false);
        athleteBtn = new Button("Βάση Αθλητη");
        athleteBtn.setDisable(true);
        athleteBtn.setVisible(false);
        trainingBtn = new Button("Βάση Προγράμματος");
        trainingBtn.setDisable(true);
        trainingBtn.setVisible(false);

        // Customize btnflowPane
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newReservationBtn);
        buttonFlowPane.getChildren().add(showReservationListBtn);
        buttonFlowPane.getChildren().add(deleteReservationBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);

        // Customize gridPane
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(reservationLbl, 0, 0);
        inputFieldsPane.add(reservationFiled, 1, 0);
        inputFieldsPane.add(athleteUniqueIDLbl, 0, 1);
        inputFieldsPane.add(athleteUniqueIDField, 1, 1);
        inputFieldsPane.add(trainingProgramUniqueIDLbl, 0, 2);
        inputFieldsPane.add(trainingProgramUniqueIDField, 1, 2);
        inputFieldsPane.add(dateOfReservationLbl, 0, 3);
        inputFieldsPane.add(dateOfReservationField, 1, 3);
        inputFieldsPane.add(dateTodayLbl, 0, 4);
        inputFieldsPane.add(dateTodayField, 1, 4);
        inputFieldsPane.add(futureBtn, 0, 5);
        inputFieldsPane.add(pastBtn, 1, 5);
        inputFieldsPane.add(athleteBtn, 0, 6);
        inputFieldsPane.add(trainingBtn, 1, 6);

        // Customize tableView
        TableColumn<ReservationData, String> reservationIDColumn = new TableColumn<>("Κωδικός Κράτησης");
        reservationIDColumn.setCellValueFactory(new PropertyValueFactory<>("reservationID"));
        reservationTableView.getColumns().add(reservationIDColumn);
        reservationIDColumn.setPrefWidth(125);

        TableColumn<ReservationData, String> athleteUniqueIDColumn = new TableColumn<>("Κωδικός Αθλητή");
        athleteUniqueIDColumn.setCellValueFactory(new PropertyValueFactory<>("athleteUniqueID"));
        reservationTableView.getColumns().add(athleteUniqueIDColumn);
        athleteUniqueIDColumn.setPrefWidth(110);

        TableColumn<ReservationData, String> trainingProgramUniqueIDColumn = new TableColumn<>("Κωδικός Προγράμματος");
        trainingProgramUniqueIDColumn.setCellValueFactory(new PropertyValueFactory<>("trainingProgramUniqueID"));
        reservationTableView.getColumns().add(trainingProgramUniqueIDColumn);
        trainingProgramUniqueIDColumn.setPrefWidth(150);

        TableColumn<ReservationData, String> dateColumn = new TableColumn<>("Ημερομηνία Κράτησης");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        reservationTableView.getColumns().add(dateColumn);
        dateColumn.setPrefWidth(140);

        reservationTableView.setVisible(false);

        // Customize rootScene
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(reservationTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
        rootGridPane.add(backBtn, 1, 2);

        // Attach events
        backBtn.setOnAction(this);
        newReservationBtn.setOnAction(this);
        showReservationListBtn.setOnAction(this);
        deleteReservationBtn.setOnAction(this);
        reservationTableView.getSelectionModel().selectedItemProperty().addListener((observable, previous, selected) -> {
            if (selected != null) handle(new ActionEvent(reservationTableView, reservationTableView));
        });
        futureBtn.setOnAction(this);
        pastBtn.setOnAction(this);
        athleteBtn.setOnAction(this);
        trainingBtn.setOnAction(this);
    }

    @Override
    Scene createScene() {

        return ViewStyle.workspace("Κρατήσεις", "Προγραμματισμός προπονήσεων, φίλτρα ημερομηνίας και ακυρώσεις.",
                rootGridPane, reservationTableView, inputFieldsPane, buttonFlowPane, backBtn);
    }

    @Override
    public void handle(ActionEvent event) {

        int athleteUniqueID = -1;
        int trainingProgramUniqueID = -1;

        if(event.getSource() == backBtn) {

            App.primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
            App.primaryStage.setScene(App.mainScene);
        }

        if(event.getSource() == newReservationBtn) {

            boolean errorAthleteID = true;	//value of variable determines if athlete exists
            boolean errorTrainingID = true;  //value of variable determines if training program exists
            boolean correctIDs = true;

            try {  //check if the fields have correct type of input

                athleteUniqueID = Integer.parseInt(athleteUniqueIDField.getText());

            } catch(NumberFormatException e) {

                correctIDs = false;			//take output if all correct

                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη τιμή");
                alertType.setContentText("η τιμή που δόθηκε για κωδικό προγράμματος δεν είναι αριθμός \n Exception message: "+ e.getMessage());
                alertType.show();

                clearTextFields();
            }

            if(correctIDs == true) {

                try {

                    trainingProgramUniqueID = Integer.parseInt(trainingProgramUniqueIDField.getText());
                }
                catch(NumberFormatException e) {

                    correctIDs = false;			//take output if all correct

                    Alert alertType = new Alert(Alert.AlertType.ERROR);
                    alertType.setTitle("Μη έγκυρη τιμή");
                    alertType.setContentText("η τιμή που δόθηκε για κωδικό προγράμματος δεν είναι αριθμός \n Exception message: "+ e.getMessage());
                    alertType.show();

                    clearTextFields();
                }
            }

            if(correctIDs == true) {

                if(isValidDate(dateOfReservationField.getText())) {	 //check if date is correct

                        String date = dateOfReservationField.getText();

                        for(Athlete d : SceneCreator.getAthletesListPaid()) {  //find the athlete

                            if (d.getUniqueID() == athleteUniqueID) {

                                errorAthleteID = false;	 //athlete found

                                for(TrainingProgram c : getTrainingProgramsList()) {

                                    if(trainingProgramUniqueID == c.getUniqueID()) {

                                        errorTrainingID = false;  //program found

                                        int i = 1;
                                        boolean subscriptionExist = false;

                                        for(Subscription f : getSubscriptionsList()) {	//find if athlete subscribed to the program

                                            if (f.getUniqueID().equals(String.valueOf(d.getUniqueID()) + "_" +  String.valueOf(c.getUniqueID()) + "_<" + String.valueOf(i) + ">")) {

                                                subscriptionExist = true;
                                                break;
                                            }
                                            else
                                                i++;
                                        }
                                        if(c.getReservWeeklyReq()) {
                                            if (subscriptionExist) {  //athlete is subscribed to the program so they are eligible to make a reservation

                                                if(!(ReservationsList.isEmpty())){	//to make sure no reservation overlaps we check first if we have reservation and then do the necessary checks

                                                    for(ReservationData p : ReservationsList) {

                                                        if (p.getAthleteUniqueID() == d.getUniqueID()) {	//for the correct athlete

                                                            if(p.getDate().equals(date)) {	//check for reservation that day

                                                                if(p.getTrainingProgramUniqueID() == c.getUniqueID()) {	//check if a reservation with the same training program is already reserved for the athlete that date

                                                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                                                    alert.setTitle("Σφάλμα!");
                                                                    alert.setContentText("Ο συγκεκριμένος αθηλτής έχει ήδη κανει κράτηση με το πρόγραμμα για εκείνη την ημέρα.");
                                                                    alert.show();

                                                                    break;
                                                                    }
                                                                    else {

                                                                        createTrainingProgramReservation(d , c , date);
                                                                        updateReservationList(d , c , date);
                                                                        break;
                                                                    }
                                                                }
                                                                else {

                                                                    createTrainingProgramReservation(d , c , date);
                                                                    updateReservationList(d , c , date);
                                                                    break;
                                                            }
                                                        }
                                                        else {

                                                            createTrainingProgramReservation(d , c , date);
                                                            updateReservationList(d , c , date);

                                                            break;
                                                        }
                                                     }
                                                }
                                                else {

                                                    createTrainingProgramReservation(d , c , date);
                                                    updateReservationList(d , c , date);
                                                    break;
                                                }

                                            }
                                            else {

                                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                                alert.setTitle("Σφάλμα!");
                                                alert.setContentText("Ο συγκεκριμένος αθηλτής δεν έχει συνδρομή στο συγκεκριμένο πρόγραμμα");
                                                alert.show();

                                                break;
                                            }
                                        }
                                        else {

                                            Alert alert = new Alert(Alert.AlertType.ERROR);
                                            alert.setTitle("Σφάλμα!");
                                            alert.setContentText("Το συγκεκριμένος πρόγραμμα δεν χρειάζεται κράτηση");
                                            alert.show();
                                            break;
                                        }
                                    }
                                }

                                if(errorTrainingID) {	//if training program was not found

                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Σφάλμα!");
                                    alert.setContentText("Το συγκεκριμένος πρόγραμμα δεν υπάρχει");
                                    alert.show();

                                    break;
                                }
                            }
                        }

                        if(errorAthleteID) {	//athlete not found

                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Σφάλμα!");
                            alert.setContentText("Ο συγκεκριμένος αθηλτής δεν υπάρχει");
                            alert.show();
                        }
                }

                clearTextFields();
                tableSync();
            }
        }

        if(event.getSource() == showReservationListBtn) {

            reservationTableView.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Διαχείριση Πίνακα");
            alert.setContentText("Για την εμφάνιση των μελλοντικών κρατήσεων ή για ιστορικό, συμπληρώστε τη σημερινή ημερομηνία και πατήστε το αντίστοιχο κουμπί.\nΓια να φιλτράρετε τον πίνακα με βάση τον αθλητη ή το πρόγραμμα, "
                                + "συμπληρώστε τα πεδία με τις σωστές τιμές και πατήστε το αντίστοιχο κουμπί.\nΓια να επαναφέρετε την αρχική μορφή του πίνακα πατήστε πάλι εμφάνιση πίνακα");
            alert.show();

            futureBtn.setDisable(false);	//show new options to sort table view
            futureBtn.setVisible(true);
            pastBtn.setDisable(false);
            pastBtn.setVisible(true);
            athleteBtn.setDisable(false);
            athleteBtn.setVisible(true);
            trainingBtn.setDisable(false);
            trainingBtn.setVisible(true);
            dateTodayField.setVisible(true);
            dateTodayField.setEditable(true);
            dateTodayLbl.setVisible(true);

            clearTextFields();
            tableSync();
        }

        if(event.getSource() ==  pastBtn) {	//to show older reservations from today

            String date;

            if(isValidDate(dateTodayField.getText())) {

                date = dateTodayField.getText();

                ObservableList<ReservationData> items = reservationTableView.getItems();

                items.clear();

                for(ReservationData d: ReservationsList) {

                    if(isFirstDateSmallerOrEqual(d.getDate(), date)) {	//adds dates only smaller or equal compared to today date

                        items.add(d);
                    }
                }
            }

            clearTextFields();
        }

        if(event.getSource() == futureBtn) {	//show future reservations

            String date;

            if(isValidDate(dateTodayField.getText())) {

                date = dateTodayField.getText();
                ObservableList<ReservationData> items = reservationTableView.getItems();
                items.clear();

                for(ReservationData d: ReservationsList) {
                    if(isFirstDateSmallerOrEqual(date, d.getDate())) {	//adds dates only larger or equal compared to today date

                        items.add(d);
                    }
                }
            }

            clearTextFields();
        }

        if(event.getSource() == athleteBtn) {

            int athleteID = -1;

            try {  //check if the fields have correct type of input

                athleteID = Integer.parseInt(athleteUniqueIDField.getText());

            }
            catch(NumberFormatException e) {

                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη τιμή");
                alertType.setContentText("η τιμή που δόθηκε για κωδικό προγράμματος δεν είναι αριθμός \n Exception message: "+ e.getMessage());
                alertType.show();

                clearTextFields();
                return;	//end method if input is not integer
            }

            ObservableList<ReservationData> items = reservationTableView.getItems();

            items.clear();

            for(ReservationData d: ReservationsList) {

                if(d.getAthleteUniqueID() == athleteID) {

                    items.add(d);
                }
            }

            clearTextFields();
        }

        if(event.getSource() == trainingBtn) {

            int trainingID;

            try {  //check if the fields have correct type of input

                trainingID = Integer.parseInt(trainingProgramUniqueIDField.getText());

            }
            catch(NumberFormatException e) {

                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη τιμή");
                alertType.setContentText("η τιμή που δόθηκε για κωδικό προγράμματος δεν είναι αριθμός \n Exception message: "+ e.getMessage());
                alertType.show();

                clearTextFields();
                return;		//end method if input is not integer
            }

            ObservableList<ReservationData> items = reservationTableView.getItems();

            items.clear();

            for(ReservationData d: ReservationsList) {

                if(d.getTrainingProgramUniqueID() == trainingID) {

                    items.add(d);
                }
            }

            clearTextFields();
        }

        if(event.getSource() == deleteReservationBtn) {

            Alert alertType = new Alert(Alert.AlertType.INFORMATION);
            alertType.setTitle("Ακύρωση Κράτησης");
            alertType.setContentText("Για την ακύρωση συμπληρώστε την σημερινή ημερομηνία");
            alertType.show();

            dateTodayField.setVisible(true);
            dateTodayField.setEditable(true);
            dateTodayLbl.setVisible(true);

            String date;
            String selectedReservationID;

            if(isValidDate(dateTodayField.getText())) {

                date = dateTodayField.getText();

                if(!(reservationFiled.getText().equals(""))) {

                    selectedReservationID = reservationFiled.getText();


                    //find matching reservationID
                    int i = 0;

                    for(ReservationData m: ReservationsList) {

                        if(selectedReservationID.equals(m.getReservationID())) {

                            if(canCancelReservation(date, m.getDate())) {

                                //remove reservation from both lists
                                TrainingProgramReservationsList.remove(i);
                                ReservationsList.remove(i);

                                tableSync();

                                break;
                            }
                            else {

                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Ακυρωση Κράτησης");
                                alert.setContentText("Η κράτηση μπορεί να ακυρωθεί μονο μέχρι και 1 μέρα πριν την προγραμματισμένη ημερομηνία");
                                alert.show();
                                break;
                            }
                        }
                        else
                            i++;
                    }
                }
                else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ακυρωση Κράτησης");
                    alert.setContentText("Επιλεξτε πρωτα μια κράτηση");
                    alert.show();

                    return;
                }
            }
        }

        if(event.getSource() == reservationTableView) {

            ReservationData selectedReservation = reservationTableView.getSelectionModel().getSelectedItem();

            if (selectedReservation != null) {

                reservationFiled.setText(selectedReservation.getReservationID());

                dateOfReservationField.setText(selectedReservation.getDate());

                athleteUniqueIDField.setText(Integer.toString(selectedReservation.getAthleteUniqueID()));

                trainingProgramUniqueIDField.setText(Integer.toString(selectedReservation.getTrainingProgramUniqueID()));
            }
        }
    }

    public void createTrainingProgramReservation(Athlete athlete, TrainingProgram trainingProgram, String trainingProgramDate) {

        TrainingProgramReservation trainingProgramReservation = new TrainingProgramReservation(TrainingProgramReservation.generateTrainingProgramReservationID(athlete.getUniqueID(), trainingProgram.getUniqueID(), trainingProgramDate), athlete, trainingProgram, trainingProgramDate);
        TrainingProgramReservationsList.add(trainingProgramReservation);
    }

    public void updateReservationList(Athlete athlete, TrainingProgram trainningProgram, String date) {

        for(TrainingProgramReservation p : TrainingProgramReservationsList) {

            if (p.getUniqueID().equals(String.valueOf("<" + String.valueOf(athlete.getUniqueID()) + "_" + String.valueOf(trainningProgram.getUniqueID())  //generate unique id based on athleteID, trainingProgramID and
                + "_" + date + ">"))) {	//for the correct athlete


                ReservationData reservationData = new ReservationData(p.getUniqueID(), athlete, trainningProgram, date);
                ReservationsList.add(reservationData);
            }
        }
    }

    public void clearTextFields() {

           reservationFiled.setText("");
           dateOfReservationField.setText("");
           athleteUniqueIDField.setText("");
           trainingProgramUniqueIDField.setText("");
    }

    public void tableSync() {

        ObservableList<ReservationData> items = reservationTableView.getItems();

        items.clear();

        for(ReservationData d: ReservationsList) {

            items.add(d);
        }
    }

    public static boolean isFirstDateSmallerOrEqual(String first, String second) {
        return DateRules.isOnOrBefore(first, second);
    }

    public static boolean canCancelReservation(String today, String reservationDate) {
        return DateRules.canCancel(today, reservationDate);
    }
}
