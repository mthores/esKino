package sample;


import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class addMovie {

    //This scenes controls the addMovie scene

    @FXML private Button addButton;
    @FXML private Label savedLabel;







    public void addMovie(){
        //call the DB

        //sets the label to 
        savedLabel.setText("Movie saved!");

        //clear the savedLabel to nothing!
        PauseTransition delayforclear = new PauseTransition(Duration.seconds(5));
        delayforclear.setOnFinished(e-> savedLabel.setText(""));
        delayforclear.play();



    }


}
