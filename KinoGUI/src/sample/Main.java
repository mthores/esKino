package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.Button;
=======
import javafx.scene.control.TableView;
>>>>>>> f09194a4da0e8fe1bd670a85891ad1a0cf28e0b5
import javafx.stage.Stage;
import sample.View.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/forestillinger.fxml"));
        Controller.initializeController(primaryStage);
        primaryStage.setTitle("EsKino");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
<<<<<<< HEAD

=======
        TableView<Object> tW3 = new TableView<>();
>>>>>>> f09194a4da0e8fe1bd670a85891ad1a0cf28e0b5

    }




    public static void main(String[] args) {
        launch(args);
    }
}