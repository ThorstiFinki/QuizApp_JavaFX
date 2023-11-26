package com.example.QuizApp_JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerMenu2 implements Initializable {


    @FXML
    private Button categoryComputer;

    @FXML
    private Button category_ProLang;

    @FXML
    private Button categoryJava;

    @FXML
    private Button categoryGermany;

    @FXML
    private Button categoryAnimals;

    @FXML
    private Label categoryLabel;

    @FXML
    private HBox statusHBox;

    // Welche Kategorie soll im Quiz erscheinen
    ArrayList<String> categoryList = new ArrayList<String>();

    // ************** Category **************
    @FXML
    void categoryComputerButton_clicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        getCategory(button.getText(), button);

    }

    @FXML
    void category_ProLangButton_clicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        getCategory(button.getText(), button);
    }

    @FXML
    void categoryJavaButton_clicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        getCategory(button.getText(), button);
    }

    @FXML
    void categoryGermanyButton_clicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        getCategory(button.getText(), button);
    }

    @FXML
    void categoryAnimalsButton_clicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        getCategory(button.getText(), button);
    }

    // ************** HBox Status **************
    @FXML
    void ChancelButton_clicked(ActionEvent event) {
        categoryComputer.setDisable(false);
        category_ProLang.setDisable(false);
        categoryJava.setDisable(false);
        categoryGermany.setDisable(false);
        categoryAnimals.setDisable(false);

        statusHBox.setDisable(true);
        categoryLabel.setText("");
    }

    @FXML
    void OKButton_clicked(ActionEvent event) {

    }











    // ************** initialize **************
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Statusbox einsschalten
        statusHBox.setDisable(true);

    }

    // ************** Methoden **************
    private void getCategory(String category, Button button) {
        // Kategorie speichern
        categoryList.add(category);

        // Unten im Label den Namen anzeigen
        categoryLabel.setText(categoryLabel.getText() + " " + category);

        // Kategorie Button ausblenden
        button.setDisable(true);

        // Statusbox einsschalten
        statusHBox.setDisable(false);
    }
}
