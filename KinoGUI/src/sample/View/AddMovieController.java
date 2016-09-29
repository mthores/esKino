package sample.View;


import javafx.animation.PauseTransition;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Model.Film;
import sample.Presenter.DBController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class AddMovieController {

    //This scenes controls the AddMovieController scene

    DBController dbController = new DBController();

    @FXML private Label savedLabel;
    @FXML public TextField titelText;
    @FXML public TextField durationText;
    @FXML public TextField ticketPriceText;
    @FXML public TextField lincensPriceText;
    @FXML public TextArea descriptionArea;
    @FXML public ImageView picturePreview;
    @FXML public ComboBox genreCombo;
    @FXML public ComboBox ratingCombo;


    public void toFilmButtonClicked() throws IOException {

        Parent filmParent = FXMLLoader.load(getClass().getResource("Film.fxml"));
        Scene showScene = new Scene(filmParent);
        LoginSalMainmenuController.mainStage.setScene(showScene);
    }


    public void addMovieAction(){
        //call the DB

        //sets the label to "Saved"
        savedLabel.setText("Movie saved!");

        //clear the savedLabel to nothing!
        PauseTransition delayforclear = new PauseTransition(Duration.seconds(5));
        delayforclear.setOnFinished(e-> savedLabel.setText(""));
        delayforclear.play();

        //clear the fields
        clearFields();
    }


    public void clearFields(){
        titelText.clear();
        durationText.clear();
        ticketPriceText.clear();
        lincensPriceText.clear();
        descriptionArea.clear();
        //picturePreview - ??
        genreCombo.setValue("Genre");
        ratingCombo.setValue("Rating");
    }

    public void saveFilmToDB(){

        String titel = titelText.getText();
        String description = descriptionArea.getText();
        int ticketPrice = Integer.parseInt(ticketPriceText.getText());
        String duration = durationText.getText();
        String genre = genreCombo.getSelectionModel().getSelectedItem().toString();
        String rating = ratingCombo.getSelectionModel().getSelectedItem().toString();
        int licensPrice = Integer.parseInt(lincensPriceText.getText());

        Film newFilm = new Film(titel, description, ticketPrice, duration, genre, rating, licensPrice);

        dbController.buildDataFilm(newFilm);

        addMovieAction();

    }



}
