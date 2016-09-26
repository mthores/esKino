package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.TableView;
=======
>>>>>>> 14769a7676d1a48a85564a7ab96a76d9891f81b2
import javafx.stage.Stage;
import sample.View.LoginSalMainmenuController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));
        LoginSalMainmenuController.initializeController(primaryStage);
        primaryStage.setTitle("EsKino");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

<<<<<<< HEAD
        TableView<Object> tW3 = new TableView<>();
=======

>>>>>>> 14769a7676d1a48a85564a7ab96a76d9891f81b2
    }



    public static void main(String[] args) {
        launch(args);
    }
}