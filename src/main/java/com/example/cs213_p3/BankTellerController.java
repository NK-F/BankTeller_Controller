package com.example.cs213_p3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * Controller class responsible for accepting input for JavaFX view and parsing them for interaction with data model
 * @author Nicolas Karris-Flores
 * @author Kyle Mlynarski
 */

public class BankTellerController {

    @FXML
    private ToggleGroup accountType = new ToggleGroup();

    @FXML
    private ToggleGroup loyalty = new ToggleGroup();

    @FXML
    private ToggleGroup campusCode = new ToggleGroup();

    @FXML
    private ToggleGroup action = new ToggleGroup();

    @FXML
    private TextArea printArea;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;


    @FXML
    private GridPane gridPane;

    @FXML
    private Label directionsLabel1;

    @FXML
    private Label directionsLabel2;

    @FXML
    private Label dobLabel;

    @FXML
    private Label fnameLabel;

    @FXML
    private Label lnameLabel;

    @FXML
    private Label depositLabel;

    @FXML
    private Label withdrawLabel;

    @FXML
    private Label errorMessageAmount;

    @FXML
    private Label profileErrorMessage;

    @FXML
    private TextField depositField;

    @FXML
    private TextField withdrawField;

    @FXML
    private TextField fnameField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField lnameField;

    @FXML
    private RadioButton newBrunswickRB;

    @FXML
    private RadioButton newarkRB;

    @FXML
    private RadioButton notLoyalRB;

    @FXML
    private RadioButton camdenRB;

    @FXML
    private RadioButton loyalRB;

    @FXML
    private Button openButton;

    @FXML
    private javafx.scene.control.Button closeButton;

    private AccountDatabase sessionDB = new AccountDatabase();

    /**
     * Event handler responsible for processing onAction for all buttons in stage
     *
     * @param event
     */
    @FXML
    void anyButtonClickTerminal(ActionEvent event) {
        Button button = (Button) event.getSource();

        switch (button.getText()) {
            case "Quit" -> {
                Platform.exit();
            }
            case "Submit" -> {
                RadioButton actionRadioButton = (RadioButton) action.getSelectedToggle();
                String actionName = actionRadioButton.getText();

                RadioButton accountRadioButton = (RadioButton) accountType.getSelectedToggle();
                String accountName = accountRadioButton.getText();

                RadioButton campusCRadioButton = (RadioButton) campusCode.getSelectedToggle();
                String campusCode = campusCRadioButton.getText();

                RadioButton loyaltyRadioButton = (RadioButton) loyalty.getSelectedToggle();
                String loyalty = loyaltyRadioButton.getText();

                double testDummy = 0.0;
                boolean flag = false;

                switch (actionName) {
                    case "open" -> {
                        switch (accountName) {
                            case "Checking" -> {
                                if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                    try {
                                        testDummy = Double.parseDouble(depositField.getText());
                                    } catch (NumberFormatException e) {
                                        printArea.appendText("Invalid deposit value.\n");
                                    }
                                    Date dummyDate = new Date(dobField.getText());
                                    if (dummyDate.isValid()) {
                                        Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                        sessionDB.open(new Checking(profile, testDummy));
                                        printArea.appendText("Account opened.\n");
                                        flag = true;
                                    } else {
                                        printArea.appendText("Invalid date.");
                                    }
                                    printArea.appendText("Fill in text boxes.\n");
                                }
                                if (flag) {
                                    gridPane.getChildren().clear();
                                }
                            }
                            case "College Checking" -> {
                                switch (campusCode) {
                                    case "New Brunswick" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.open(new CollegeChecking(profile, testDummy, 0));
                                                printArea.appendText("Account opened.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Newark" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.open(new CollegeChecking(profile, testDummy, 1));
                                                printArea.appendText("Account opened.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Camden" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.open(new CollegeChecking(profile, testDummy, 2));
                                                printArea.appendText("Account opened.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    default -> {
                                        printArea.appendText("Select campus code.\n");
                                    }
                                }
                            }
                            case "Savings" -> {
                                switch (loyalty) {
                                    case "Loyal" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.open(new Savings(profile, testDummy, true));
                                                printArea.appendText("Account opened.\n");
                                                flag = true;
                                            } else {
                                                printArea.appendText("Invalid date.");
                                            }
                                            printArea.appendText("Fill in text boxes.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Not Loyal" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.open(new Savings(profile, testDummy, false));
                                                printArea.appendText("Account opened.\n");
                                                flag = true;
                                            } else {
                                                printArea.appendText("Invalid date.");
                                            }
                                            printArea.appendText("Fill in text boxes.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                }

                            }
                            case "Money Market" -> {
                                if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                    try {
                                        testDummy = Double.parseDouble(depositField.getText());
                                    } catch (NumberFormatException e) {
                                        printArea.appendText("Invalid deposit value.\n");
                                    }
                                    Date dummyDate = new Date(dobField.getText());
                                    if (dummyDate.isValid()) {
                                        Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                        sessionDB.open(new MoneyMarket(profile, testDummy));
                                        printArea.appendText("Account opened.\n");
                                        flag = true;
                                    } else {
                                        printArea.appendText("Invalid date.");
                                    }
                                    printArea.appendText("Fill in text boxes.\n");
                                }
                                if (flag) {
                                    gridPane.getChildren().clear();
                                }
                            }
                        }
                    }
                    case "close" -> {
                        switch (accountName) {
                            case "Checking" -> {
                                if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                    Date dummyDate = new Date(dobField.getText());
                                    if (dummyDate.isValid()) {
                                        Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                        sessionDB.close(new Checking(profile, testDummy));
                                        printArea.appendText("Account closed.\n");
                                        flag = true;
                                    } else {
                                        printArea.appendText("Invalid date.");
                                    }
                                    printArea.appendText("Fill in text boxes.\n");
                                }
                                if (flag) {
                                    gridPane.getChildren().clear();
                                }
                            }
                            case "College Checking" -> {
                                switch (campusCode) {
                                    case "New Brunswick" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {

                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.close(new CollegeChecking(profile, testDummy, 0));
                                                printArea.appendText("Account closed.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Newark" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {

                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.close(new CollegeChecking(profile, testDummy, 1));
                                                printArea.appendText("Account closed.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Camden" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {

                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.close(new CollegeChecking(profile, testDummy, 2));
                                                printArea.appendText("Account closed.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    default -> {
                                        printArea.appendText("Select campus code.\n");
                                    }
                                }
                            }
                            case "Savings" -> {
                                switch (loyalty) {
                                    case "Loyal" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {

                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.close(new Savings(profile, testDummy, true));
                                                printArea.appendText("Account closed.\n");
                                                flag = true;
                                            } else {
                                                printArea.appendText("Invalid date.");
                                            }
                                            printArea.appendText("Fill in text boxes.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Not Loyal" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {

                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.close(new Savings(profile, testDummy, false));
                                                printArea.appendText("Account closed.\n");
                                                flag = true;
                                            } else {
                                                printArea.appendText("Invalid date.");
                                            }
                                            printArea.appendText("Fill in text boxes.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                }

                            }
                            case "Money Market" -> {
                                if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {

                                    Date dummyDate = new Date(dobField.getText());
                                    if (dummyDate.isValid()) {
                                        Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                        sessionDB.close(new MoneyMarket(profile, testDummy));
                                        printArea.appendText("Account closed.\n");
                                        flag = true;
                                    } else {
                                        printArea.appendText("Invalid date.");
                                    }
                                    printArea.appendText("Fill in text boxes.\n");
                                }
                                if (flag) {
                                    gridPane.getChildren().clear();
                                }
                            }
                        }
                    }
                    case "deposit" -> {
                        switch (accountName) {
                            case "Checking" -> {
                                if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                    try {
                                        testDummy = Double.parseDouble(depositField.getText());
                                    } catch (NumberFormatException e) {
                                        printArea.appendText("Invalid deposit value.\n");
                                    }
                                    Date dummyDate = new Date(dobField.getText());
                                    if (dummyDate.isValid()) {
                                        Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                        sessionDB.deposit(new Checking(profile, testDummy));
                                        printArea.appendText("Deposit - balance updated.\n");
                                        flag = true;
                                    } else {
                                        printArea.appendText("Invalid date.");
                                    }
                                    printArea.appendText("Fill in text boxes.\n");
                                }
                                if (flag) {
                                    gridPane.getChildren().clear();
                                }
                            }
                            case "College Checking" -> {
                                switch (campusCode) {
                                    case "New Brunswick" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.deposit(new CollegeChecking(profile, testDummy, 0));
                                                printArea.appendText("Deposit - balance updated.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Newark" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.deposit(new CollegeChecking(profile, testDummy, 1));
                                                printArea.appendText("Deposit - balance updated.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Camden" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.deposit(new CollegeChecking(profile, testDummy, 2));
                                                printArea.appendText("Deposit - balance updated.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    default -> {
                                        printArea.appendText("Select campus code.\n");
                                    }
                                }
                            }
                            case "Savings" -> {
                                switch (loyalty) {
                                    case "Loyal" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.deposit(new Savings(profile, testDummy, true));
                                                printArea.appendText("Deposit - balance updated.\n");
                                                flag = true;
                                            } else {
                                                printArea.appendText("Invalid date.");
                                            }
                                            printArea.appendText("Fill in text boxes.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Not Loyal" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.deposit(new Savings(profile, testDummy, false));
                                                printArea.appendText("Deposit - balance updated.\n");
                                                flag = true;
                                            } else {
                                                printArea.appendText("Invalid date.");
                                            }
                                            printArea.appendText("Fill in text boxes.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                }

                            }
                            case "Money Market" -> {
                                if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                    try {
                                        testDummy = Double.parseDouble(depositField.getText());
                                    } catch (NumberFormatException e) {
                                        printArea.appendText("Invalid deposit value.\n");
                                    }
                                    Date dummyDate = new Date(dobField.getText());
                                    if (dummyDate.isValid()) {
                                        Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                        sessionDB.deposit(new MoneyMarket(profile, testDummy));
                                        printArea.appendText("Deposit - balance updated.\n");
                                        flag = true;
                                    } else {
                                        printArea.appendText("Invalid date.");
                                    }
                                    printArea.appendText("Fill in text boxes.\n");
                                }
                                if (flag) {
                                    gridPane.getChildren().clear();
                                }
                            }
                        }
                    }
                    case "Withdraw" -> {
                        switch (accountName) {
                            case "Checking" -> {
                                if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                    try {
                                        testDummy = Double.parseDouble(depositField.getText());
                                    } catch (NumberFormatException e) {
                                        printArea.appendText("Invalid deposit value.\n");
                                    }
                                    Date dummyDate = new Date(dobField.getText());
                                    if (dummyDate.isValid()) {
                                        Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                        sessionDB.withdraw(new Checking(profile, testDummy));
                                        printArea.appendText("Withdraw - balance updated.\n");
                                        flag = true;
                                    } else {
                                        printArea.appendText("Invalid date.");
                                    }
                                    printArea.appendText("Fill in text boxes.\n");
                                }
                                if (flag) {
                                    gridPane.getChildren().clear();
                                }
                            }
                            case "College Checking" -> {
                                switch (campusCode) {
                                    case "New Brunswick" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.withdraw(new CollegeChecking(profile, testDummy, 0));
                                                printArea.appendText("Withdraw - balance updated.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Newark" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.withdraw(new CollegeChecking(profile, testDummy, 1));
                                                printArea.appendText("Withdraw - balance updated.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Camden" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.withdraw(new CollegeChecking(profile, testDummy, 2));
                                                printArea.appendText("Withdraw - balance updated.\n");
                                                flag = true;
                                            }
                                            printArea.appendText("Not all choices are selected.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    default -> {
                                        printArea.appendText("Select campus code.\n");
                                    }
                                }
                            }
                            case "Savings" -> {
                                switch (loyalty) {
                                    case "Loyal" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.withdraw(new Savings(profile, testDummy, true));
                                                printArea.appendText("Withdraw - balance updated.\n");
                                                flag = true;
                                            } else {
                                                printArea.appendText("Invalid date.");
                                            }
                                            printArea.appendText("Fill in text boxes.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                    case "Not Loyal" -> {
                                        if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                            try {
                                                testDummy = Double.parseDouble(depositField.getText());
                                            } catch (NumberFormatException e) {
                                                printArea.appendText("Invalid deposit value.\n");
                                            }
                                            Date dummyDate = new Date(dobField.getText());
                                            if (dummyDate.isValid()) {
                                                Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                                sessionDB.withdraw(new Savings(profile, testDummy, false));
                                                printArea.appendText("Withdraw - balance updated.\n");
                                                flag = true;
                                            } else {
                                                printArea.appendText("Invalid date.");
                                            }
                                            printArea.appendText("Fill in text boxes.\n");
                                        }
                                        if (flag) {
                                            gridPane.getChildren().clear();
                                        }
                                    }
                                }

                            }
                            case "Money Market" -> {
                                if (!(fnameField.getText() == null) && !(lnameField.getText() == null) && !(dobField.getText() == null)) {
                                    try {
                                        testDummy = Double.parseDouble(depositField.getText());
                                    } catch (NumberFormatException e) {
                                        printArea.appendText("Invalid deposit value.\n");
                                    }
                                    Date dummyDate = new Date(dobField.getText());
                                    if (dummyDate.isValid()) {
                                        Profile profile = new Profile(fnameField.getText(), lnameField.getText(), new Date(dobField.getText()));
                                        sessionDB.withdraw(new MoneyMarket(profile, testDummy));
                                        printArea.appendText("Withdraw - balance updated.\n");
                                        flag = true;
                                    } else {
                                        printArea.appendText("Invalid date.");
                                    }
                                    printArea.appendText("Fill in text boxes.\n");
                                }
                                if (flag) {
                                    gridPane.getChildren().clear();
                                }
                            }
                        }
                    }

                }

            }
            case "Display" -> {
                if (sessionDB.dbIsNotEmpty()) {
                    printArea.appendText("*list of accounts in the database*\n" + sessionDB.print() + "*end of list*\n");
                    break;
                }
                printArea.appendText("Account Database is empty!\n");
                break;

            }
            case "Display Type" -> {
                if (sessionDB.dbIsNotEmpty()) {
                    printArea.appendText("*list of accounts by account type.\n" + sessionDB.printByAccountType() + "*end of list.\n");
                    break;
                }
                printArea.appendText("Account Database is empty!\n");
                break;

            }
            case "Display Interest" -> {
                if (sessionDB.dbIsNotEmpty()) {
                    printArea.appendText("*list of accounts with fee and monthly interest\n" + sessionDB.printFeeAndInterest() + "*end of list.\n");
                    break;
                }
                printArea.appendText("Account Database is empty!\n");
                break;

            }
            case "Update Balance" -> {
                if (sessionDB.dbIsNotEmpty()) {
                    sessionDB.updateAccountBalances();
                    printArea.appendText("*list of accounts with updated balance\n" + sessionDB.print() + "*end of list.\n");
                    break;
                }
                printArea.appendText("Account Database is empty!\n");
                break;

            }

        }
    }

    /**
     * Event handler responsible for processing onAction for all radio buttons in stage
     *
     * @param event
     */

    @FXML
    private void anyRadioButtonClickTerminal(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) accountType.getSelectedToggle();
        String accountType = selectedRadioButton.getText();
        switch (accountType) {
            case "College Checking" -> {
                vbox1.setVisible(true);
            }
            case "Savings" -> {
                vbox2.setVisible(true);
            }
            default -> {
                vbox1.setVisible(false);
                vbox2.setVisible(false);
            }
        }

    }
}
