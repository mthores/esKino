package sample.View;


import javafx.animation.PauseTransition;

import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;



public class addMovie {

    //This scenes controls the addMovie scene


    @FXML private Label savedLabel;
    @FXML public TextField titelText;
    @FXML public TextField durationText;
    @FXML public TextField ticketPriceText;
    @FXML public TextField lincensPriceText;
    @FXML public TextArea descriptionArea;
    @FXML public ImageView picturePreview;
    @FXML public ComboBox genreCombo;
    @FXML public ComboBox ratingCombo;



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

}
