package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.TableView;
=======
import javafx.scene.control.Control;
import javafx.scene.shape.Rectangle;
>>>>>>> ef2d8ea110e3b0168ccb99eed5ee3915cbb338b3
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Controller.initializeController(primaryStage);
        primaryStage.setTitle("EsKino");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();
        TableView<Object> tW3 = new TableView<>();

    }




    public static void main(String[] args) {
        launch(args);
    }
}