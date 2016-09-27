package sample.View;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import sample.Model.Film;
import sample.Presenter.DBController;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ShowManagementController{

    public static ObservableList<Film> setDataToComboxObservableList = FXCollections.observableArrayList();
    public static ObservableList setDataToTableViewObservableList = FXCollections.observableArrayList();

    @FXML private CheckBox hallCheckbox1;
    @FXML private CheckBox hallCheckbox2;
    @FXML private DatePicker datepicker;
    @FXML private ComboBox selectMovieCombo;
    @FXML private ComboBox selectTimeCombo;

    public void selectedMovieFromDB(){


    }

    public int selectedCheckbox(){

        int count=0;
        int choices = 0;
        if(hallCheckbox1.isSelected()){
            count++;
            choices = 1;
        }
        if(hallCheckbox2.isSelected()){
            count++;
            choices = 2;
        }
        return choices;

    }

    public void setDataToCombobox(){
        DBController dbController = new DBController();
        dbController.getMovieFromDB();

        selectMovieCombo.setItems(setDataToComboxObservableList);
    }


    public void setDataToTableview(){

        String selectedCombo;
        String date;
        String selectedTimeCombo;
        int hall;

        selectedCombo = selectMovieCombo.getSelectionModel().getSelectedItem().toString();
        hall = selectedCheckbox();
        date = String.valueOf(datepicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        selectedTimeCombo = selectTimeCombo.getSelectionModel().getSelectedItem().toString();

        System.out.println("Movie: " + selectedCombo);
        System.out.println("sal: " + hall);
        System.out.println("date: " + date);
        System.out.println("tid: " + selectedTimeCombo);






    }



}
