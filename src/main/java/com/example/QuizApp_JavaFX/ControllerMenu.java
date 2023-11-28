package com.example.QuizApp_JavaFX;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.PopUpWindow;

import java.io.IOException;
import java.util.Objects;


public class ControllerMenu {


    @FXML
    void startButton_Clicked(ActionEvent event) throws IOException {
       // System.out.println("Start");

        Button button =(Button) event.getSource();
        Stage primaryStage =(Stage) button.getScene().getWindow();
        primaryStage.close();

        try{
        goToCategoryOverview();}
        catch (Exception e){
            e.printStackTrace();
            PopUpWindow.display("Datei nicht gefunden! \n Programm bitte neu starten!");
        }

    }

    @FXML
    void scoreButton_Clicked(ActionEvent event) {
       /// System.out.println("Score");
        PopUpWindow.display("Kein Score vorhanden!");
    }
    @FXML
    void quit_ButtonClicked(ActionEvent event) {
        //System.out.println("Quit");
        Platform.exit();
    }

    private void goToCategoryOverview() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu2.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());

        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.setTitle("Kategorie Auswahl");
        stage2.setResizable(false);
        stage2.show();


    }



}


