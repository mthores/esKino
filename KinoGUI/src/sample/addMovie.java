package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class addMovie {

    //This scenes controls the addMovie scene

    @FXML private Button addButton;
    @FXML private Label savedLabel;







    public void addMovie(){
        //call the DB

        savedLabel.setText("Movie saved!");




    }


}
