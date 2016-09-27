package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableRow;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.*;


//import java.io.IOException;

public class Controller {

    private static MouseEvent e;
    private static Stage mainStage;
    @FXML private TextField username;
    @FXML private PasswordField password;

    @FXML private Label infoLabelCinema;
    @FXML private Label ticketCount;
    @FXML private Label totalPrice;
    private int tC;

    @FXML private Rectangle s11;
    @FXML private Rectangle s12;
    @FXML private Rectangle s13;
    @FXML private Rectangle s14;
    @FXML private Rectangle s15;
    @FXML private Rectangle s16;
    @FXML private Rectangle s17;
    @FXML private Rectangle s18;
    @FXML private Rectangle s19;
    @FXML private Rectangle s110;
    @FXML private Rectangle s111;
    @FXML private Rectangle s112;

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

    @FXML TableView <Object> tW2 = new TableView<>();

    public void administrationButtonClicked() throws  IOException {
        Parent administrationParent = FXMLLoader.load(getClass().getResource("Film.fxml"));
        Scene administrationScene = new Scene(administrationParent);

        tW2.setRowFactory(tW2 -> {
            TableRow<Object> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Object rowData = row.getItem();
                    System.out.println(rowData);
                }
            });
        });


        mainStage.setScene(administrationScene);

    }

    public void addMovieButtonClicked() throws IOException {
        Parent addMovieParent = FXMLLoader.load(getClass().getResource("addMovie.fxml"));
        Scene addMovieScene = new Scene(addMovieParent);
        mainStage.setScene(addMovieScene);
    }

    public void editMovieButtonClicked() throws IOException {
        //if (e.getSource() != null) {
            Parent editMovieParent = FXMLLoader.load(getClass().getResource("EditMovie.fxml"));
            Scene editMovieScene = new Scene(editMovieParent);
            mainStage.setScene(editMovieScene);
        //}
    }


    public void seatClicked(MouseEvent e){
            infoLabelCinema.setText("");
            Rectangle rect = (Rectangle) e.getSource();
            Paint rectColor = rect.getFill();
            String name = rect.getId();

            if (rectColor == Color.LIMEGREEN) {
                rect.setFill(Color.DODGERBLUE);
                tC++;
            }

            if (rectColor == Color.RED) {
                infoLabelCinema.setText("Sædet er optaget.");
            }

            if (rectColor == Color.DODGERBLUE) {
                rect.setFill(Color.LIMEGREEN);
                tC--;
            }

            updateTicketCounters();
        }

    public void updateTicketCounters(){
        ticketCount.setText(""+tC);
        totalPrice.setText(""+tC*85+" Kroner");
    }
}
