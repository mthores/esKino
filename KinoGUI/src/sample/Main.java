package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

<<<<<<< HEAD
=======

>>>>>>> 7346247e5bccb5accea671f842a5a2ea76e4329f

import javafx.scene.control.Button;


import javafx.scene.control.TableView;


import javafx.stage.Stage;
import sample.View.LoginSalMainmenuController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

<<<<<<< HEAD
=======

>>>>>>> 7346247e5bccb5accea671f842a5a2ea76e4329f
       // Parent root = FXMLLoader.load(getClass().getResource("View/Film.fxml"));


        Parent root = FXMLLoader.load(getClass().getResource("View/AddMovie.fxml"));


<<<<<<< HEAD

        //Parent root = FXMLLoader.load(getClass().getResource("View/Film.fxml"));

=======
>>>>>>> 7346247e5bccb5accea671f842a5a2ea76e4329f
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