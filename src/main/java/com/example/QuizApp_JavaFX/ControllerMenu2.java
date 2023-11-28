package com.example.QuizApp_JavaFX;

import Application.ControllerQuiz;
import dbUtil.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import model.PopUpWindow;
import model.Question;
import model.QuestionBank;

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

    @FXML
    private Circle DBStatus_light;


    // Liste mit Fragen
    ArrayList<Question> quizQuestionList = new ArrayList<>();

    // Welche Kategorie soll im Quiz erscheinen
    ArrayList<String> categoryList = new ArrayList<String>();

    // Database
    Database database = new Database();
    QuestionBank questionBank = new QuestionBank();


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

        for (String category : categoryList) {
            questionBank.loadCategoryQuestions(database.getStatement(), category);
        }

        quizQuestionList = questionBank.getQuestionsList();

        // Nur zum testen
//	    	for (Question question : quizQuestionList) {
//				System.out.println("ID " + question.getQuestion_id());
//				System.out.println("Frage " + question.getQuestion_text());
//				System.out.println("Antwort " + question.isQuestion_answer());
//				System.out.println("Ergänzung " + question.getQuestion_complement());
//			}

        // Das Kategorie Fenster schließen
        Button okButton = (Button) event.getSource();
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();

        try {
            startQuiz();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ************** initialize **************
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Statusbox einsschalten
        statusHBox.setDisable(true);

        // Database Stuff
        boolean dbConnection = database.open();

        if (dbConnection) {

         //  DBStatus_light.setFill(Color.gray(5)  );
        } else {
           // DBStatus_light.setFill(Color.RED);
            PopUpWindow.display("Keine Verbindung möglich \n Programm bitte neu starten");
        }

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

    private void startQuiz() throws IOException {
        Stage stage3 = new Stage();
        stage3.setTitle("Quiz App");

        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(Main.class.getResource("quiz.fxml")));
        Scene scene3 = new Scene(fxmlLoader.load());

        // Die ArrayList mit den Fragen muss zum ControllerQuiz, mit getController() erhält man die Controller Klasse aus der fxml Datei
        ControllerQuiz controllerQuiz = fxmlLoader.getController();
        controllerQuiz.setQuestions(quizQuestionList);


        stage3.setScene(scene3);
        stage3.setResizable(false);
        stage3.show();
    }
}
