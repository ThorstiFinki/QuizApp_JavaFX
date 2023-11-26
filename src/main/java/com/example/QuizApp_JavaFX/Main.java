package com.example.QuizApp_JavaFX;;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);

    }



}
