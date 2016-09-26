package sample.View;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowManagementController implements Initializable{


    @FXML private CheckBox hallCheckbox1;
    @FXML private CheckBox hallCheckbox2;

    public void selectedMovieFromDB(){


    }

    public String selectedCheckbox(ActionEvent e){

        int count=0;
        String choices="";
        if(hallCheckbox1.isSelected()){
            count++;
            choices+=hallCheckbox1.getText() + "\n";
        }
        if(hallCheckbox2.isSelected()){
            count++;
            choices+=hallCheckbox2.getText() + "\n";
        }
        System.out.println(choices);

        return choices;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}