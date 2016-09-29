package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.control.Button;


import javafx.scene.control.TableView;

import javafx.stage.Stage;
import sample.View.LoginSalMainmenuController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

       // Parent root = FXMLLoader.load(getClass().getResource("View/Film.fxml"));


        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));



        LoginSalMainmenuController.initializeController(primaryStage);
        primaryStage.setTitle("EsKino");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.show();


        //TableView<Object> tW3 = new TableView<>();
    }


    public static void main(String[] args) {
        launch(args);
    }
}