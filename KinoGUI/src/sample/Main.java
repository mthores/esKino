package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
<<<<<<< HEAD


import javafx.scene.control.Button;

import javafx.scene.control.Button;

=======

>>>>>>> 588954374b2e24dad36dc316cac49d356d4b9339
import javafx.scene.control.TableView;

=======
>>>>>>> 7a9ca29c2601f2cd81d48f93b4e6c32ae49a7f3c
import javafx.stage.Stage;
import sample.View.LoginSalMainmenuController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("View/Film.fxml"));
>>>>>>> 7a9ca29c2601f2cd81d48f93b4e6c32ae49a7f3c
        LoginSalMainmenuController.initializeController(primaryStage);
        primaryStage.setTitle("EsKino");
        primaryStage.setScene(new Scene(root, 1280, 820));
        primaryStage.show();


        //TableView<Object> tW3 = new TableView<>();
    }


    public static void main(String[] args) {
        launch(args);
    }
}