package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD

import javafx.scene.control.Button;
=======
<<<<<<< HEAD
>>>>>>> 90479fd2d6225b4c414ae700926ea86e09b156dc
import javafx.scene.control.TableView;

import javafx.stage.Stage;
import sample.View.LoginSalMainmenuController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));
        LoginSalMainmenuController.initializeController(primaryStage);
        primaryStage.setTitle("EsKino");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


        TableView<Object> tW3 = new TableView<>();
    }


    public static void main(String[] args) {
        launch(args);
    }
}