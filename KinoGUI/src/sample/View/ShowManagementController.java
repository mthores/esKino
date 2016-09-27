package sample.View;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowManagementController{



    @FXML private CheckBox hallCheckbox1;
    @FXML private CheckBox hallCheckbox2;

    @FXML private ComboBox selectMovieCombo;

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

    public void setDataToCombobox(){

        ObservableList setDataToComboxObservableList = FXCollections.observableArrayList();

        selectMovieCombo.getItems().clear();
        //ObservableList to combox
        selectMovieCombo.setItems(setDataToComboxObservableList);


    }



}
