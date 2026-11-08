package com.example.academy.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import com.example.academy.model.Athlete;
import com.example.academy.model.AthleteData;
import com.example.academy.model.Enrollment;
import com.example.academy.model.Payment;
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

public class AthleteSceneCreator extends SceneCreator implements EventHandler<ActionEvent> {

    //List of athletes
    ArrayList<User> athletesList;
    ArrayList<Enrollment> enrollmentsList;
    //Flow panel
    FlowPane buttonFlowPane;
    //Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    //HBoxes
    HBox genderHBox, professionalHBox, paymentHBox;
    //ToggleGroup
    ToggleGroup genderToggleGroup, professionalToggleGroup, paymentToggleGroup;
    //Scene buttons
    Button newAthleteBtn, paymentBtn, showListBtn, updateAthleteBtn, backBtn;
    //radio buttons
    RadioButton maleRadioButton, femaleRadioButton, isProfessionalRadioButton, notProfessionalRadioButton, cardRadioButton, cashRadioButton;
    //Scene labels
    Label uniqueIDLbl, nameLbl, lastNameLbl, genderLbl, dateOfBirthLbl, contactInfoLbl,professionalLbl, experienceLbl, paymentLbl, dateLbl;
    //Text field
    TextField uniqueIDField, nameField, lastNameField, genderField ,dateOfBirthField, contactInfoField, professionalField, experienceField, dateField;
    //Table view
    TableView<AthleteData> athleteTableView;



    public AthleteSceneCreator (double width, double height) {

        super(width, height);

        // Initialize the list of athletes
        athletesList = new ArrayList<>();
        enrollmentsList = new ArrayList<>();

        // Initialize the FlowPane
        buttonFlowPane = new FlowPane();

        // Initialize the GridPanes
        rootGridPane = new GridPane();
        inputFieldsPane = new GridPane();

        // Initialize HBoxes
        genderHBox = new HBox(10);
        professionalHBox = new HBox(10);
        paymentHBox = new HBox(10);

        // ToggleGroup
        genderToggleGroup  = new ToggleGroup();
        professionalToggleGroup = new ToggleGroup();
        paymentToggleGroup = new ToggleGroup();

        // Initialize tableView
        athleteTableView = new TableView<>();

        // Initialize the Labels
        uniqueIDLbl = new Label("Κωδικός:");
        nameLbl = new Label("Όνομα:");
        lastNameLbl = new Label("Επώνυμο:");
        genderLbl = new Label("Φύλο:");
        dateOfBirthLbl = new Label("Ημερομηνία Γέννησης:");
        contactInfoLbl = new Label("Στοιχεία Επικοινωνίας:");
        professionalLbl = new Label("Επαγγελματίας:");
        experienceLbl = new Label("Εμπειρία:");
        paymentLbl = new Label("Τρόπος Πληρωμής");
        paymentLbl.setVisible(false);
        dateLbl =  new Label ("Ημερομηνία Εγγραφής");
        dateLbl.setVisible(false);

        // Initialize the Radio Buttons
        maleRadioButton = new RadioButton("Άνδρας");
        femaleRadioButton = new RadioButton("Γυναίκα");
        isProfessionalRadioButton = new RadioButton("Επαγγελματίας");
        notProfessionalRadioButton = new RadioButton("αρχάριος");
        cardRadioButton = new RadioButton("Κάρτα");
        cashRadioButton = new RadioButton("Μετρητά");


        // Initialize the Buttons
        newAthleteBtn = new Button("Καταχώρηση");
        paymentBtn = new Button("Πληρωμή εγγραφής");
        paymentBtn.setDisable(true);
        showListBtn = new Button("Εμφάνιση λίστας");
        showListBtn.setDisable(false);
        updateAthleteBtn = new Button("Ενημέρωση");
        updateAthleteBtn.setDisable(true);
        backBtn = new Button("Επιστροφή");

        // Initialize the Text Fields
        uniqueIDField = new TextField();
        uniqueIDField.setDisable(true);
        nameField = new TextField();
        lastNameField = new TextField();
        dateOfBirthField = new TextField();
        dateOfBirthField.setPromptText("dd/MM/yyyy");
        contactInfoField = new TextField();
        experienceField = new TextField();
        experienceField.setPromptText("1–5");
        dateField = new TextField();
        dateField.setPromptText("dd/MM/yyyy");
        dateField.setEditable(false);
        dateField.setVisible(false);

        // Customize btnflowPane
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newAthleteBtn);
        buttonFlowPane.getChildren().add(updateAthleteBtn);
        buttonFlowPane.getChildren().add(paymentBtn);
        buttonFlowPane.getChildren().add(showListBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);

        // ToggleGroup Radio Buttons
        maleRadioButton.setToggleGroup(genderToggleGroup);
        femaleRadioButton.setToggleGroup(genderToggleGroup);
        maleRadioButton.setSelected(true);

        isProfessionalRadioButton.setToggleGroup(professionalToggleGroup);
        notProfessionalRadioButton.setToggleGroup(professionalToggleGroup);
        notProfessionalRadioButton.setSelected(true);

        cardRadioButton.setToggleGroup(paymentToggleGroup);
        cashRadioButton.setToggleGroup(paymentToggleGroup);
        cardRadioButton.setSelected(true);

        // Customize genderHbox
        genderHBox.getChildren().add(maleRadioButton);
        genderHBox.getChildren().add(femaleRadioButton);

        // Customize professionalHBox
        professionalHBox.getChildren().add(isProfessionalRadioButton);
        professionalHBox.getChildren().add(notProfessionalRadioButton);

        // Customize paymentHBox
        paymentHBox.getChildren().add(cardRadioButton);
        paymentHBox.getChildren().add(cashRadioButton);
        paymentHBox.setDisable(true);
        paymentHBox.setVisible(false);

        // Customize gridPane
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(uniqueIDLbl, 0, 0);
        inputFieldsPane.add(uniqueIDField, 1, 0);
        inputFieldsPane.add(nameLbl, 0, 1);
        inputFieldsPane.add(nameField, 1, 1);
        inputFieldsPane.add(lastNameLbl, 0, 2);
        inputFieldsPane.add(lastNameField, 1, 2);
        inputFieldsPane.add(genderLbl, 0, 3);
        inputFieldsPane.add(genderHBox, 1, 3);
        inputFieldsPane.add(dateOfBirthLbl, 0, 4);
        inputFieldsPane.add(dateOfBirthField, 1, 4);
        inputFieldsPane.add(contactInfoLbl, 0, 5);
        inputFieldsPane.add(contactInfoField, 1, 5);
        inputFieldsPane.add(professionalLbl, 0, 6);
        inputFieldsPane.add(professionalHBox, 1, 6);
        inputFieldsPane.add(experienceLbl, 0, 7);
        inputFieldsPane.add(experienceField, 1, 7);
        inputFieldsPane.add(paymentLbl, 0, 8);
        inputFieldsPane.add(paymentHBox, 1, 8);
        inputFieldsPane.add(dateLbl, 0, 9);
        inputFieldsPane.add(dateField, 1, 9);

        // Customize rootScene
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(athleteTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
        rootGridPane.add(backBtn, 1, 2);

        // Customize tableView
        TableColumn<AthleteData, String> uniqueIDColum = new TableColumn<>("Κωδικός");
        uniqueIDColum.setCellValueFactory(new PropertyValueFactory<>("uniqueID"));
        athleteTableView.getColumns().add(uniqueIDColum);

        TableColumn<AthleteData, String> nameColum = new TableColumn<>("Όνομα");
        nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
        athleteTableView.getColumns().add(nameColum);

        TableColumn<AthleteData, String> lastNameColum = new TableColumn<>("Επώνυμο");
        lastNameColum.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        athleteTableView.getColumns().add(lastNameColum);

        TableColumn<AthleteData, String> genderColum = new TableColumn<>("Φύλο");
        genderColum.setCellValueFactory(new PropertyValueFactory<>("gender"));
        athleteTableView.getColumns().add(genderColum);

        TableColumn<AthleteData, String> dateOfBirthColum = new TableColumn<>("Ημερομηνία Γέννησης");
        dateOfBirthColum.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        athleteTableView.getColumns().add(dateOfBirthColum);

        TableColumn<AthleteData, String> contactInfoColumn = new TableColumn<>("Στοιχεία Επικοινωνίας");
        contactInfoColumn.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));
        athleteTableView.getColumns().add(contactInfoColumn);

        TableColumn<AthleteData, String> professionalColum = new TableColumn<>("Επαγγελματίας");
        professionalColum.setCellValueFactory(new PropertyValueFactory<>("professional"));
        athleteTableView.getColumns().add(professionalColum);

        TableColumn<AthleteData, String> experienceColum = new TableColumn<>("Εμπειρία");
        experienceColum.setCellValueFactory(new PropertyValueFactory<>("experience"));
        athleteTableView.getColumns().add(experienceColum);

        TableColumn<AthleteData, String> dateColum = new TableColumn<>("Ημερομηνία Εγγραφής");
        dateColum.setCellValueFactory(new PropertyValueFactory<>("date"));
        athleteTableView.getColumns().add(dateColum);

        TableColumn<AthleteData, String> priceColum = new TableColumn<>("Τιμή");
        priceColum.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        athleteTableView.getColumns().add(priceColum);

        athleteTableView.setVisible(false);

        // Attach events
        backBtn.setOnAction(this);
        newAthleteBtn.setOnAction(this);
        updateAthleteBtn.setOnAction(this);
        paymentBtn.setOnAction(this);
        showListBtn.setOnAction(this);
        athleteTableView.getSelectionModel().selectedItemProperty().addListener((observable, previous, selected) -> {
            if (selected != null) handle(new ActionEvent(athleteTableView, athleteTableView));
        });

    }

    @Override
    Scene createScene() {

        return ViewStyle.workspace("Αθλητές", "Καταχώρηση αθλητών, ενημέρωση στοιχείων και πληρωμή εγγραφής.",
                rootGridPane, athleteTableView, inputFieldsPane, buttonFlowPane, backBtn);
    }

    @Override
    public void handle(ActionEvent event) {

        if(event.getSource() == backBtn) {	//revert to main scene
            App.primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
            App.primaryStage.setScene(App.mainScene);

        }

        if(event.getSource() == newAthleteBtn) {
            if (!validateAthleteFields()) return;
    //create new athlete

            String name = nameField.getText().trim();		//get all the text and store to variables
            String lastName = lastNameField.getText().trim();
            char gender = getGenderRadio();
            String dateOfBirth = dateOfBirthField.getText();

            if(isValidDate(dateOfBirth)) {			//make sure date has correct format

                String contactInfo = contactInfoField.getText().trim();
                boolean professional = getProfessionalRadio();		//true = is professional false is not professional
                int experience = -1;

                try {			//make sure user puts integer in the the experienceField

                     experience = Integer.parseInt(experienceField.getText());
                }
                catch (NumberFormatException e) {

                    Alert alertType = new Alert(Alert.AlertType.ERROR);
                    alertType.setTitle("Μη έγκυρη");
                    alertType.setContentText("η τιμή που δώθηκε για εμπειρία δεν είναι αριθμός. \n Exception message: "+ e.getMessage());
                    alertType.show();
                    clearTextFields();

                    return; //exit if experience is not an integer
                }

                if ((experience >= 1) && (experience <= 5)) {

                    createAthlete(name, lastName, gender, dateOfBirth, contactInfo, professional, experience);

                    Alert alertType = new Alert(Alert.AlertType.INFORMATION);
                    alertType.setTitle("Ολοκλήωση εγγραφής");
                    alertType.setContentText("Για την ολοκλήρωση της εγγραφής πρέπει να πραγματοποιηθεί η πληρωμή");
                    alertType.show();

                    newAthleteBtn.setDisable(true);			//reset buttons and show the new available options
                    nameField.setEditable(false);
                    lastNameField.setEditable(false);
                    genderHBox.setDisable(true);
                    dateOfBirthField.setEditable(false);
                    contactInfoField.setEditable(false);
                    professionalHBox.setDisable(true);
                    experienceField.setEditable(false);

                    dateField.setVisible(true);
                    dateField.setEditable(true);
                    dateLbl.setVisible(true);
                    paymentHBox.setVisible(true);
                    paymentHBox.setDisable(false);
                    paymentBtn.setDisable(false);
                    paymentLbl.setVisible(true);

                }
                else {

                    Alert alertType = new Alert(Alert.AlertType.ERROR);

                    alertType.setTitle("Σφάλμα!");
                    alertType.setContentText("Ο αριθμός που αντιπροσωπεύει την εμπειρία του αθηλήτη πρέπει να είναι στο σύνολο απο 1 έως 5");
                    alertType.show();
                }
            }
        }

        if(event.getSource() == paymentBtn) {

            String date = dateField.getText();

            if (isValidDate(date)) {	//check if date has correct format

                String paymentMethod = getPaymentMethod();		//returns either card or cash
                int uniqueID = Integer.parseInt(uniqueIDField.getText()); //get the integer that is automatically placed no need for try-catch

                for (User d : athletesList) {	//find the specific athlete based on id

                    if (d.getUniqueID() == uniqueID) {

                        Alert alertType = new Alert(Alert.AlertType.CONFIRMATION);		//show the cost
                        alertType.setTitle("Τιμή");
                        alertType.setContentText("Το κόστος ειναι: " + createPrice(d, date, paymentMethod));
                        alertType.show();
                        addToAthletesListPaid((Athlete) d);		//put him on list for table view

                        tableSync();		//sync table view
                        clearTextFields();	//clear all text fields
                    }

                    updateAthleteBtn.setDisable(false);
                }

                newAthleteBtn.setDisable(false);	//show new options now like show list
                showListBtn.setDisable(false);
                newAthleteBtn.setDisable(false);
                nameField.setEditable(true);
                lastNameField.setEditable(true);
                genderHBox.setDisable(false);
                dateOfBirthField.setEditable(true);
                contactInfoField.setEditable(true);
                professionalHBox.setDisable(false);
                experienceField.setEditable(true);
                paymentBtn.setDisable(true);

                dateField.setVisible(false);
                dateField.setEditable(false);
                dateLbl.setVisible(false);
                paymentHBox.setVisible(false);
                paymentHBox.setDisable(false);
                paymentLbl.setVisible(false);
            }
        }

        if(event.getSource() == updateAthleteBtn) {
            if (!validateAthleteFields()) return;
            if (uniqueIDField.getText().isBlank()) {
                showInputError("Επιλέξτε πρώτα έναν αθλητή από τον πίνακα.");
                return;
            }


            int uniqueID = Integer.parseInt(uniqueIDField.getText());	//get all the data from fields and store them
            String name = nameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            char gender = getGenderRadio();
            String dateOfBirth = dateOfBirthField.getText();
            int experience = -1;

            if(isValidDate(dateOfBirth)) {

                String contactInfo = contactInfoField.getText().trim();
                boolean professional = getProfessionalRadio();
                try {

                     experience = Integer.parseInt(experienceField.getText());

                } catch (NumberFormatException e) {

                    Alert alertType = new Alert(Alert.AlertType.ERROR);
                    alertType.setTitle("Μη έγκυρη τιμή");
                    alertType.setContentText("η τιμή που δώθηκε για εμπειρία δεν είναι αριθμός. \n Exception message: "+ e.getMessage());
                    alertType.show();
                    clearTextFields();
                    return; 	//end method if input is not integer
                }
                if ((experience >= 1) && (experience <= 5)) {

                    updateAthlete(uniqueID, name, lastName, gender, dateOfBirth, contactInfo, professional, experience);	//Method to replace all the data except from the id
                }
            }

            tableSync();
            clearTextFields();
        }

        if(event.getSource() == showListBtn) {

            athleteTableView.setVisible(true);	//show TableView
        }

        if (event.getSource() == athleteTableView) {

            AthleteData selectedAthlete = athleteTableView.getSelectionModel().getSelectedItem();	//make object from the selected athlete

            if(selectedAthlete != null) {	//put all data from athlete to the textFields

                uniqueIDField.setText(Integer.toString(selectedAthlete.getUniqueID()));
                nameField.setText(selectedAthlete.getName());
                lastNameField.setText(selectedAthlete.getLastName());

                if (selectedAthlete.getGender() == 'Α') {

                    maleRadioButton.setSelected(true);

                }
                else if (selectedAthlete.getGender() == 'Γ') {

                    femaleRadioButton.setSelected(true);
                }

                dateOfBirthField.setText(selectedAthlete.getDateOfBirth());
                contactInfoField.setText(selectedAthlete.getContactInfo());

                if (selectedAthlete.getProfessional()) {

                    isProfessionalRadioButton.setSelected(true);
                }
                else {

                 notProfessionalRadioButton.setSelected(true);
                }

                experienceField.setText(Integer.toString(selectedAthlete.getExperience()));
            }
        }
    }

    public void createAthlete(String name, String lastName, char gender, String dateOfBirth, String contactInfo, boolean professional,
            int experience) {	//creates new athlete object  and stores it on a list to be found later

        User d =  new Athlete(User.generateUserUniqueId(), name, lastName, gender, dateOfBirth, contactInfo, professional, experience);
        uniqueIDField.setText(Integer.toString(d.getUniqueID()));

        athletesList.add(d);
    }

    public double createPrice(User d,String date, String paymentMethod) {	//find the price to sign up for an athlete and returns it also creates enrollment and payment and stores to the correct array list

         Enrollment athleteEnrollment = new Enrollment(d.getUniqueID(), ((Athlete)d), date, 0, Enrollment.calculateDiscount(((Athlete)d).getProfessional(),((Athlete)d).getExperience()));

         athleteEnrollment.setPrice(athleteEnrollment.calculateTotalPrice());  //set enrollment price

         enrollmentsList.add(athleteEnrollment);

         Payment athletePayment = new Payment(Payment.generatePaymentUniqueID(), date, paymentMethod, athleteEnrollment, 0);

         addToPaymentsList(athletePayment);

         athletePayment.setTotalPrice(athletePayment.calculateTotalPrice());  //set payment total cost

         return athletePayment.getTotalPrice();
    }

    public void updateAthlete(int uniqueID, String name, String lastName, char gender, String dateOfBirth, String contactInfo,
                boolean professional, int experience) {		//used to replace the data from athlete

        for (User d : athletesList) {

            if (d.getUniqueID() == uniqueID) {
                d.setName(name);
                d.setLastName(lastName);
                d.setGender(gender);
                d.setDateOfBirth(dateOfBirth);
                d.setContactInfo(contactInfo);
                ((Athlete) d).setProfessional(professional);
                ((Athlete) d).setExperience(experience);
            }
        }
    }

    private String getPaymentMethod() {	//return Payment Method based on which button is selected

        if(cardRadioButton.isSelected()) {

            return "card";
        }
        else if (cashRadioButton.isSelected()) {

            return "cash";
        }
        return null;
    }

    private boolean getProfessionalRadio() {  //return if the athlete is professional based on which button is selected

        if (isProfessionalRadioButton.isSelected()) {

            return true;
        }
        else if(notProfessionalRadioButton.isSelected()) {

            return false;
        }

        return false;
    }

    private char getGenderRadio() {	//return gender based on which button is selected

        if(maleRadioButton.isSelected()) {

            return 'Α';
        }
        else if(femaleRadioButton.isSelected()) {

            return 'Γ';
        }

        return 0;
    }

    private void clearTextFields() {  //clear text fields

        uniqueIDField.setText("");
        nameField.setText("");
        lastNameField.setText("");
        dateOfBirthField.setText("");
        contactInfoField.setText("");
        experienceField.setText("");
        dateField.setText("");
    }

    public void tableSync() {	//update table view with new a data

        ObservableList<AthleteData> items = athleteTableView.getItems();

        items.clear();

        for (User d : SceneCreator.getAthletesListPaid()) {

            String date = "";
            double totalPrice = 0.0;

            for (Enrollment enrollment : enrollmentsList) {	//searching for the correct object enrollment that was created when the athlete paid

                if (enrollment.getUniqueId() == d.getUniqueID()) { //searching through id

                    date = enrollment.getDate();
                    for (Payment payment : SceneCreator.getPaymentsList()) {	//finding the correct object payment from list that matches

                        if (payment.getEnrollment() == enrollment) {	//finding based of the enrollment

                            totalPrice = payment.getTotalPrice();
                            break;
                        }
                    }
                    break;
                }
            }

            AthleteData data = new AthleteData(((Athlete) d), date, totalPrice);
            items.add(data);
        }
    }

    private boolean validateAthleteFields() {
        if (nameField.getText().isBlank() || lastNameField.getText().isBlank()
                || contactInfoField.getText().isBlank()) {
            showInputError("Συμπληρώστε όνομα, επώνυμο και στοιχεία επικοινωνίας.");
            return false;
        }
        if (!isValidDate(dateOfBirthField.getText())) return false;
        if (DateRules.parse(dateOfBirthField.getText()).isAfter(LocalDate.now())) {
            showInputError("Η ημερομηνία γέννησης δεν μπορεί να είναι μελλοντική.");
            return false;
        }
        return true;
    }

    private void showInputError(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Έλεγχος στοιχείων");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
