package com.example.academy.ui;

import java.util.ArrayList;

import com.example.academy.model.Athlete;
import com.example.academy.model.Coach;
import com.example.academy.model.Facility;
import com.example.academy.model.Payment;
import com.example.academy.model.Sport;
import com.example.academy.model.Subscription;
import com.example.academy.model.SubscriptionData;
import com.example.academy.model.TrainingProgram;
import com.example.academy.model.User;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class SubscriptionSceneCreator extends SceneCreator implements EventHandler<ActionEvent> {

    //Predefined Sports (made by programmers for the purpose of this program and are not created by the user)
    Sport volleyball;
    Sport basketball;
    Sport football;

    //Predefined Facilities (made by the programmers for this purpose of the program and are not created by the user)

    Facility volleyballCourt;
    Facility basketballCourt;
    Facility footballCourt;

    //Predefined Coaches (>>>)

    Coach volleyballCoach;
    Coach basketballCoach;
    Coach footballCoach;

    //Predefined Training Programs (>>>)

    TrainingProgram volleyballProgram;
    TrainingProgram basketballProgram;
    TrainingProgram footballProgram;

    //fields that need to be shared by mouse event methods

    int athleteUniqueID;
    int trainingProgramUniqueID;
    Athlete selectedAthlete;  //value of variable represents the athlete the user selected by entering their ID
    TrainingProgram selectedTrainingProgram;  //value of variable represents the training program the user selected by entering its ID
    String selectedSubscriptionDate;
    String subscriptionUniqueID;
    String paymentMethod;

    boolean subscriptionExists; //used to determine if the user already has a subscription to the training program the user selected

    //SubscriptionData List
    ArrayList<SubscriptionData> subscriptionDataList;  //used to display data on TableView
    //List of Sports
    ArrayList<Sport> sportsList;
    //List of Facilities
    ArrayList<Facility> facilitiesList;
    //List of Coaches
    ArrayList<Coach> coachesList;
    //List of Athletes
    ArrayList<Athlete> athletesList;
    //Flow panel
    FlowPane buttonFlowPane;
    //Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    //HBoxes
    HBox paymentHBox;
    //Scene buttons
    Button newSubscriptionBtn, paymentBtn, showListBtn, backBtn, cancelBtn;
    //ToggleGroup
    ToggleGroup paymentToggleGroup;
    //Radio Buttons
    RadioButton cardRadioButton, cashRadioButton;
    //Scene labels
    Label subscriptionUniqueIDLbl, athleteUniqueIDLbl, trainingProgramUniqueIDLbl, monthlyCostLbl, paymentLbl, subscriptionDateLbl, paymentHBoxLbl;
    //Text field
    TextField subscriptionUniqueIDTextField, athleteUniqueIDTextField, trainingProgramUniqueIDTextField, subscriptionDateTextField;
    //Table view
    TableView<SubscriptionData> subscriptionTableView;



    public SubscriptionSceneCreator(double width, double height) {
        super(width, height);

        // Initialize the lists
        subscriptionDataList = new ArrayList<>();
        sportsList = new ArrayList<>();
        coachesList = new ArrayList<>();
        facilitiesList = new ArrayList<>();

        /*--------------SPORT DATA--------------*/

        volleyball = new Sport("Volleyball", true);
        basketball = new Sport("Basketball", true);
        football = new Sport("Football", false);

        /*-------------------------------------*/




        /*------------FACILITY DATA------------*/

        volleyballCourt = new Facility("Volleyball Court", 80);
        basketballCourt = new Facility("Basketball Court", 100);
        footballCourt = new Facility("FootballCourt", 150);

        /*-------------------------------------*/




        /*--------------COACH DATA-------------*/

        volleyballCoach = new Coach(User.generateUserUniqueId(), "Alex", "Coach", 'Α', "07/09/1958", "volleyball.coach@example.com", volleyball, "VolleyballDiploma");
        basketballCoach = new Coach(User.generateUserUniqueId(), "Sam", "Coach", 'Α', "01/01/1976", "basketball.coach@example.com", basketball, "BasketballDiploma");
        footballCoach = new Coach(User.generateUserUniqueId(), "Jamie", "Coach", 'Γ', "18/03/1999", "football.coach@example.com", football, "FootballDiploma");

        /*-------------------------------------*/




        /*--------TRAINING PROGRAM DATA--------*/

        volleyballProgram = new TrainingProgram(TrainingProgram.generateTrainingProgramUniqueId(), volleyball, volleyballCourt, volleyballCoach, 2, true, 'Γ', 30, "Monday");
        basketballProgram = new TrainingProgram(TrainingProgram.generateTrainingProgramUniqueId(), basketball, basketballCourt, basketballCoach, 5, false, 'Α', 90, "Friday");
        footballProgram = new TrainingProgram(TrainingProgram.generateTrainingProgramUniqueId(), football, footballCourt, footballCoach, 4, true, 'Μ', 120, "Sunday"); // Reminder: 'M' for both genders

        /*-------------------------------------*/



        /*--ADD DATA TO THE APPROPRIATE LISTS--*/

        //Sports
        sportsList.add(volleyball);
        sportsList.add(basketball);
        sportsList.add(football);

        //Facilities
        facilitiesList.add(volleyballCourt);
        facilitiesList.add(basketballCourt);
        facilitiesList.add(footballCourt);

        //Coach
        coachesList.add(volleyballCoach);
        coachesList.add(basketballCoach);
        coachesList.add(footballCoach);

        //TrainingProgram
        SceneCreator.addToTrainingProgramsList(volleyballProgram);
        SceneCreator.addToTrainingProgramsList(basketballProgram);
        SceneCreator.addToTrainingProgramsList(footballProgram);

        /*-------------------------------------*/




        // Initialize the FlowPane
        buttonFlowPane = new FlowPane();

        // Initialize the GridPanes
        rootGridPane = new GridPane();
        inputFieldsPane = new GridPane();

        // Initialize TableView
        subscriptionTableView = new TableView<>();

        // Initialize the Labels
        subscriptionUniqueIDLbl = new Label("Κωδικός Συνδρομής: ");
        athleteUniqueIDLbl = new Label("Κωδικός Αθλητή: ");
        trainingProgramUniqueIDLbl = new Label("Κωδικός Προγράμματος: ");
        paymentHBoxLbl = new Label("Τρόπος Πληρωμής: ");
        paymentHBoxLbl.setVisible(false);
        subscriptionDateLbl = new Label("Ημερομηνία Εγγραφής");
        subscriptionDateLbl.setVisible(false);

        // trainingProgramUniqueIDLbl
        monthlyCostLbl = new Label("Μηνιαίο κόστος: ");
        paymentLbl = new Label("Τρόπος Πληρωμής");
        paymentLbl.setVisible(false);
        subscriptionDateLbl =  new Label ("Ημερομηνία Εγγραφής");
        subscriptionDateLbl.setVisible(false);

        // Initialize the Buttons
        newSubscriptionBtn = new Button("Νέα συνδρομή");
        paymentBtn = new Button("Πληρωμή συνδρομής");
        paymentBtn.setDisable(true);  //disable payment button on startup
        showListBtn = new Button("Εμφάνιση λίστας");
        backBtn = new Button("Επιστροφή");
        cancelBtn = new Button("Ακύρωση");
        cancelBtn.setDisable(true);

        // initialize HBoxes
        paymentHBox = new HBox(10);

        // Initialize the Text Fields
        subscriptionUniqueIDTextField = new TextField();
        subscriptionUniqueIDTextField.setEditable(false);
        subscriptionUniqueIDTextField.setDisable(true);
        athleteUniqueIDTextField = new TextField();
        trainingProgramUniqueIDTextField = new TextField();
        subscriptionDateTextField = new TextField();
        subscriptionDateTextField.setPromptText("dd/MM/yyyy");
        subscriptionDateTextField.setVisible(false);

        // ToggleGroup
        paymentToggleGroup  = new ToggleGroup();

        // Initialize Radio Buttons
        cardRadioButton = new RadioButton("Κάρτα");
        cardRadioButton.alignmentProperty();
        cashRadioButton = new RadioButton("Μετρητά");

        // ToggleGroup Radio Buttons
        cardRadioButton.setToggleGroup(paymentToggleGroup);
        cashRadioButton.setToggleGroup(paymentToggleGroup);
        cardRadioButton.setSelected(true);

        // Customize HBox
        paymentHBox.getChildren().add(cardRadioButton);
        paymentHBox.getChildren().add(cashRadioButton);
        paymentHBox.setDisable(true);
        paymentHBox.setVisible(false);

        // Customize btnflowPane
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newSubscriptionBtn);
        buttonFlowPane.getChildren().add(paymentBtn);
        buttonFlowPane.getChildren().add(cancelBtn);
        buttonFlowPane.getChildren().add(showListBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);

        // Customize gridPane
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(12);
        inputFieldsPane.add(subscriptionUniqueIDLbl, 0, 0);
        inputFieldsPane.add(subscriptionUniqueIDTextField, 1, 0);
        inputFieldsPane.add(athleteUniqueIDLbl, 0, 1);
        inputFieldsPane.add(athleteUniqueIDTextField, 1, 1);
        inputFieldsPane.add(trainingProgramUniqueIDLbl, 0, 2);
        inputFieldsPane.add(trainingProgramUniqueIDTextField, 1, 2);
        inputFieldsPane.add(paymentHBoxLbl, 0, 8);
        inputFieldsPane.add(paymentHBox, 1, 8);
        inputFieldsPane.add(subscriptionDateLbl, 0, 9);
        inputFieldsPane.add(subscriptionDateTextField, 1, 9);

        // Customize rootScene
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(subscriptionTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
        rootGridPane.add(backBtn, 1, 2);

        // Customize tableView
        subscriptionTableView.setPrefWidth(600);

        TableColumn<SubscriptionData, String> uniqueIDColumn = new TableColumn<>("Κωδικός Συνδρομής");
        uniqueIDColumn.setCellValueFactory(new PropertyValueFactory<>("SubscriptionUniqueID"));
        subscriptionTableView.getColumns().add(uniqueIDColumn);
        uniqueIDColumn.setPrefWidth(170);

        TableColumn<SubscriptionData, String> athleteUniqueIDColumn = new TableColumn<>("Κωδικός Αθλητή");
        athleteUniqueIDColumn.setCellValueFactory(new PropertyValueFactory<>("athleteUniqueID"));
        subscriptionTableView.getColumns().add(athleteUniqueIDColumn);
        athleteUniqueIDColumn.setPrefWidth(120);

        TableColumn<SubscriptionData, String> trainingProgramUniqueIDColumn = new TableColumn<>("Κωδικός Προγράμματος");
        trainingProgramUniqueIDColumn.setCellValueFactory(new PropertyValueFactory<>("trainingProgramUniqueID"));
        subscriptionTableView.getColumns().add(trainingProgramUniqueIDColumn);
        trainingProgramUniqueIDColumn.setPrefWidth(160);

        TableColumn<SubscriptionData, String> monthlyCostColumn = new TableColumn<>("Μηνιαίο Κόστος");
        monthlyCostColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyCost"));
        subscriptionTableView.getColumns().add(monthlyCostColumn);
        monthlyCostColumn.setPrefWidth(110);

        subscriptionTableView.setVisible(false);

        // Attach events
        backBtn.setOnAction(this);
        newSubscriptionBtn.setOnAction(this);
        paymentBtn.setOnAction(this);
        showListBtn.setOnAction(this);
        cancelBtn.setOnAction(this);
        subscriptionTableView.getSelectionModel().selectedItemProperty().addListener((observable, previous, selected) -> {
            if (selected != null) handle(new ActionEvent(subscriptionTableView, subscriptionTableView));
        });
    }

    @Override
    Scene createScene() {

        return ViewStyle.workspace("Συνδρομές", "Σύνδεση αθλητών με προγράμματα προπόνησης και διαχείριση πληρωμών.",
                rootGridPane, subscriptionTableView, inputFieldsPane, buttonFlowPane, backBtn);
    }

    @Override
    public void handle(ActionEvent event) {

        if(event.getSource() == backBtn) {
            App.primaryStage.setTitle("Διαχειριση Αθλητικων Ακαδημιων");
            App.primaryStage.setScene(App.mainScene);
        }

        if(event.getSource() == newSubscriptionBtn) {


            athleteUniqueID = -1;
            trainingProgramUniqueID = -1;
            selectedAthlete = null;  //value of variable represents the athlete the user selected by entering their ID
            selectedTrainingProgram = null;  //value of variable represents the training program the user selected by entering its ID

            subscriptionExists = false; //used to determine if the user already has a subscription to the training program the user selected


            String athleteUniqueIDUserInput = athleteUniqueIDTextField.getText();  //user's text field input in athlete unique Id text field
            boolean athleteInt = true;  //checks if user's input is correct before value is assigned to athleteUniqueID

            String TrainingProgramUniqueIDUserInput = trainingProgramUniqueIDTextField.getText();  //user's text field input in training program unique ID text field
            boolean programInt = true;  //checks if user's input is correct before value is assigned to trainingProgramUniqueID

            //check if user's input is a number
            try {

                athleteUniqueID = Integer.parseInt(athleteUniqueIDUserInput);  //catch input type miss-match
            }
            catch (NumberFormatException e) {  //display error if user's input is not a number

                athleteInt = false;

                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη τιμή");
                alertType.setContentText("η τιμή που δόθηκε για κωδικό προγράμματος δεν είναι αριθμός \n Exception message: "+ e.getMessage());
                alertType.show();

                clearTextFields();
            }

            try {

                trainingProgramUniqueID = Integer.parseInt(TrainingProgramUniqueIDUserInput);  //catch input type miss-match
            }
            catch (NumberFormatException e) {  //display error if user's input is not a number

                programInt = false;

                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη τιμή");
                alertType.setContentText("η τιμή που δόθηκε για κωδικό αθλητή δεν είναι αριθμός \n Exception message: "+ e.getMessage());
                alertType.show();

                clearTextFields();
            }

            if(athleteInt == true) {

                athleteUniqueID = Integer.parseInt(athleteUniqueIDUserInput);  //value is indeed a number so assign it to athleteUniqueID
            }

            if(programInt == true) {

                trainingProgramUniqueID = Integer.parseInt(TrainingProgramUniqueIDUserInput);  //value is indeed a number so assign it to athleteUniqueID
            }


            //if athleteUniqueID and trainingProgramUniqueID are valid find a matching athlete and training program
            if((athleteInt == true) && (programInt = true)) {

                athletesList = getAthletesListPaid();

                for (Athlete d : athletesList) {  //get list of athletes (Who have paid) from AthleteSceneCreator and determine which one from that list the user selected

                    if(athleteUniqueID == d.getUniqueID()) {

                        selectedAthlete = d;  //matching athlete found

                        break;
                    }
                }


                for (TrainingProgram c : getTrainingProgramsList()) {  //determine which training program the user selected

                    if(trainingProgramUniqueID == c.getUniqueID()) {

                        selectedTrainingProgram = c;  //matching training program found

                        break;
                    }
                }


                //ensure that a matching athlete and program were found before using their values below
                if (selectedAthlete == null || selectedTrainingProgram == null) {


                    Alert alertType = new Alert(Alert.AlertType.ERROR);

                    if(selectedAthlete == null) {

                        alertType.setTitle("Σφάλμα!");
                        alertType.setContentText("Ο μοναδικός κωδικός που δώσατε δεν ανήκει σε κανέναν αθλητή");
                        alertType.show();

                        clearTextFields();
                    }
                    else {

                        alertType.setTitle("Σφάλμα!");
                        alertType.setContentText("Ο μοναδικός κωδικός που δώσατε δεν ανήκει σε κανένα πρόγραμμα");
                        alertType.show();

                        clearTextFields();
                    }
                }
                else {

                    //check if athlete already has a subscription to this training program by checking if the subscription uniqueID that would have been generated already exists
                    int i = 1;

                    for(Subscription f : getSubscriptionsList()) {

                        if (f.getUniqueID().equals(String.valueOf(selectedAthlete.getUniqueID()) + "_" +  String.valueOf(selectedTrainingProgram.getUniqueID()) + "_<" + String.valueOf(i) + ">")) {

                            Alert alertType = new Alert(Alert.AlertType.ERROR);

                            alertType.setTitle("Σφάλμα!");
                            alertType.setContentText("Ο συγκεκριμένος αθηλτής έχει ήδη συνδρομή στο συγκεκριμένο πρόγραμμα");
                            alertType.show();

                            subscriptionExists = true;

                            clearTextFields();

                            break;
                        }
                        else
                            i++;
                    }

                    if(subscriptionExists == false) {

                        if(selectedTrainingProgram.checkRequiredGender(selectedAthlete)) {  //check if athlete is eligible to participate to
                                                                                            //the training program they selected

                            if(selectedAthlete.getExperience() >= selectedTrainingProgram.getMinRequiredExp()) {

                                Alert alertType = new Alert(Alert.AlertType.INFORMATION);

                                alertType.setTitle("Προσοχή");
                                alertType.setContentText("Για να πραγματοποιηθεί η συνδρομή στο συγκεκριμένο πρόγραμμα θα πρέπει να πραγματοποιηθεί η πληρωμή");
                                alertType.show();

                                newSubscriptionBtn.setDisable(true);

                                //prevent user from changing data in case a new subscription is awaiting payment
                                athleteUniqueIDTextField.setEditable(false);
                                trainingProgramUniqueIDTextField.setEditable(false);

                                paymentHBox.setVisible(true);
                                paymentHBox.setDisable(false);
                                paymentHBoxLbl.setVisible(true);
                                paymentHBoxLbl.setDisable(false);

                                subscriptionDateLbl.setVisible(true);
                                subscriptionDateTextField.setVisible(true);

                                paymentBtn.setDisable(false);  //if the athlete doesn't have a subscription to the specific training program and has entered all required data, enable payment button

                            }
                            else {

                                Alert alertType = new Alert(Alert.AlertType.ERROR);

                                alertType.setTitle("Σφάλμα!");
                                alertType.setContentText("Το επίπεδο του αθλητή δεν είναι αρκετά υψηλό για να συμμετάσχει στο συγκεκριμένο πρόγραμμα");
                                alertType.show();
                            }

                        }
                        else {

                            Alert alertType = new Alert(Alert.AlertType.ERROR);

                            alertType.setTitle("Σφάλμα!");
                            alertType.setContentText("Ο συγκεκριμένος αθλητής δεν μπορεί να συμμετάσχει στο συγκεκριμένο πρόγραμμα (μη αποδεκτό φύλο)");
                            alertType.show();
                        }
                    }
                    else {

                        clearTextFields();
                    }
                }
            }
        }


        if(event.getSource() == paymentBtn) {

            //the subscription the user selected is valid to be created

            //generate subscription's Unique ID
            subscriptionUniqueID = Subscription.generateSubscriptionUniqueId(selectedAthlete.getUniqueID(), selectedTrainingProgram.getUniqueID());

            subscriptionUniqueIDTextField.setText(subscriptionUniqueID);


            String SubscriptionDateUserInput = subscriptionDateTextField.getText();

            if(isValidDate(SubscriptionDateUserInput)) {

                selectedSubscriptionDate = SubscriptionDateUserInput;
                paymentMethod = getPaymentMethod();

                Subscription athleteSubscription = new Subscription(subscriptionUniqueID, selectedAthlete, selectedTrainingProgram, 0);

                athleteSubscription.setMonthlyCost(athleteSubscription.calculateTotalPrice());

                addToSubscriptionsList(athleteSubscription);

                SubscriptionData subscriptionData = new SubscriptionData(athleteSubscription);
                subscriptionDataList.add(subscriptionData);

                Payment athletePayment = new Payment(Payment.generatePaymentUniqueID(), selectedSubscriptionDate, paymentMethod, athleteSubscription, 0);

                athletePayment.setTotalPrice(athletePayment.calculateTotalPrice());  //set payment total price

                athleteSubscription.setMonthlyCost(athletePayment.calculateTotalPrice());

                addToPaymentsList(athletePayment);

                Alert alertType = new Alert(Alert.AlertType.INFORMATION);
                alertType.setTitle("Επιτυχία!");
                alertType.setContentText("η πληρωμή ολοκληρώθηκε με επιτυχία");
                alertType.show();

                //reset buttons
                newSubscriptionBtn.setDisable(false);
                paymentBtn.setDisable(true);
                athleteUniqueIDTextField.setEditable(true);
                trainingProgramUniqueIDTextField.setEditable(true);

                clearTextFields();

                //reset buttons
                paymentHBox.setVisible(false);
                paymentHBox.setDisable(true);
                paymentHBoxLbl.setVisible(false);
                paymentHBoxLbl.setDisable(true);

                subscriptionDateLbl.setVisible(false);
                subscriptionDateTextField.setVisible(false);

                paymentBtn.setDisable(true);
            }
        }

        if(event.getSource() == showListBtn) {

            tableSync();

            subscriptionTableView.setVisible(true);
        }

        if(event.getSource() == subscriptionTableView) {

            SubscriptionData selectedSubscription = subscriptionTableView.getSelectionModel().getSelectedItem();

            if(selectedSubscription != null) {  //set textFields to match those of the subscription the user selected

                subscriptionUniqueIDTextField.setText(selectedSubscription.getSubscriptionUniqueID());
                athleteUniqueIDTextField.setText(String.valueOf(selectedSubscription.getAthleteUniqueID()));
                trainingProgramUniqueIDTextField.setText(String.valueOf(selectedSubscription.getTrainingProgramUniqueID()));
            }
        }

        if(event.getSource() == cancelBtn) {

            String selectedSubscriptionUniqueID;

            if(!(subscriptionUniqueIDTextField.getText().equals(""))) {

                selectedSubscriptionUniqueID = subscriptionUniqueIDTextField.getText();


                //find matching subscription
                int i = 0;

                for(SubscriptionData m: subscriptionDataList) {

                    if(selectedSubscriptionUniqueID.equals(m.getSubscriptionUniqueID())) {

                        //remove subscription from both lists
                        removeFromSubscriptionsList(i);
                        subscriptionDataList.remove(i);

                        tableSync();

                        break;
                    }
                    else
                        i++;
                }
            }
        }

        tableSync();
    }

    private String getPaymentMethod() {

        if(cardRadioButton.isSelected()) {

            return "card";
        }
        else if (cashRadioButton.isSelected()) {

            return "cash";
        }
        return null;
    }

    private void clearTextFields() {

        subscriptionUniqueIDTextField.setText("");
        athleteUniqueIDTextField.setText("");
        trainingProgramUniqueIDTextField.setText("");
        subscriptionDateTextField.setText("");
    }

    private void tableSync() {

        ObservableList<SubscriptionData> items = subscriptionTableView.getItems();

        items.clear();

        for(SubscriptionData m: subscriptionDataList) {

                items.add((SubscriptionData)m);
        }

        if(subscriptionDataList.size() != 0) {

            cancelBtn.setDisable(false);  //if list is not empty enable cancel button
        }
        else
            cancelBtn.setDisable(true); //else disable
    }
}
