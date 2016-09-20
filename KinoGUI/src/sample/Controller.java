package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    private static Stage mainStage;
    @FXML private TextField username;
    @FXML private PasswordField password;

    public static void initializeController(Stage stage){
        mainStage = stage;
    }

    public void loginButtonClicked() throws IOException {

        if(username.getText().equals("admin") && password.getText().equals("admin")) {
            System.out.println("logged in succesfully!");

            toMenuButtonClicked();


        } else {
            System.out.println("login failed. Bad credentials!");
        }
    }

    public void logOffButtonClicked() throws IOException{

        Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginScene = new Scene(loginParent);
        mainStage.setScene(loginScene);
    }

    public void reservationMenuClicked() throws IOException {

        Parent reservationParent = FXMLLoader.load(getClass().getResource("reservationsside.fxml"));
        Scene reservationScene = new Scene(reservationParent);
        mainStage.setScene(reservationScene);
    }

    public void toMenuButtonClicked() throws IOException {

        Parent mainMenuParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        Scene mainMenuScene = new Scene(mainMenuParent);
        mainStage.setScene(mainMenuScene);
    }

    public void reserveButtonClicked() throws IOException {

        Parent cinemaParent = FXMLLoader.load(getClass().getResource("sal.fxml"));
        Scene cinemaScene = new Scene(cinemaParent);
        mainStage.setScene(cinemaScene);
    }

    @FXML private String s11;

    public void chooseSeat(Rectangle s11) {

        s11.setFill(Color.FORESTGREEN);

    }

}
