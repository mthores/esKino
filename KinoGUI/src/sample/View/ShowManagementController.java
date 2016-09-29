package sample.View;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Model.Film;
import sample.Model.Shows;
import sample.Presenter.DBConnection;
import sample.Presenter.DBController;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ShowManagementController{

    DBController dbController = new DBController();


    public static ObservableList<Film> setDataToComboxObservableList = FXCollections.observableArrayList();
    public static ObservableList setDataToTableViewObservableList = FXCollections.observableArrayList();

    @FXML private CheckBox hallCheckbox1;
    @FXML private CheckBox hallCheckbox2;
    @FXML private DatePicker datepicker;
    @FXML private ComboBox selectMovieCombo;
    @FXML private ComboBox selectTimeCombo;
    @FXML private TableColumn<Shows, String> tableColTitel;
    @FXML private TableColumn<Shows, String> tableColTime;
    @FXML private TableColumn<Shows, Integer> tableColHall;
    @FXML private TableColumn<Shows, String> tableColDate;
    @FXML private TableView<Shows> showTableView;


    public void toFilmButtonClicked() throws IOException {

        Parent filmParent = FXMLLoader.load(getClass().getResource("Film.fxml"));
        Scene filmScene = new Scene(filmParent);
        LoginSalMainmenuController.mainStage.setScene(filmScene);

    }

    @FXML
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

    @FXML
    public void setDataToCombobox(){
        DBController dbController = new DBController();
        dbController.getMovieFromDB();

        selectMovieCombo.setItems(setDataToComboxObservableList);
    }

    @FXML
    public void savedataToDB(){

        String selectedCombo;
        String date;
        String selectedTimeCombo;
        int hall;

        selectedCombo = selectMovieCombo.getSelectionModel().getSelectedItem().toString();
        hall = selectedCheckbox();
        date = String.valueOf(datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        selectedTimeCombo = selectTimeCombo.getSelectionModel().getSelectedItem().toString();

        Shows newShows = new Shows(selectedCombo, hall, date, selectedTimeCombo);

        dbController.buildDataShowManagement(newShows);

        setDataToTableview();

        clearFields();
    }

    @FXML
    public void setDataToTableview(){

        dbController.refreshTableview();

        tableColTitel.setCellValueFactory(new PropertyValueFactory<>("movieTitel"));
        tableColHall.setCellValueFactory(new PropertyValueFactory<>("cinemaHall"));
        tableColDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableColTime.setCellValueFactory(new PropertyValueFactory<>("time"));


        showTableView.setItems(setDataToTableViewObservableList);

    }

    public void clearFields(){
        selectMovieCombo.setValue("Select movie");
        hallCheckbox1.setSelected(false);
        hallCheckbox2.setSelected(false);
        datepicker.setValue(null);
        selectTimeCombo.setValue(null);
    }


    public void removeMovieFromTableView(){
        SimpleIntegerProperty index2 = new SimpleIntegerProperty();

        DBController dbController = new DBController();

        dbController.deletedFromShowMangement(showTableView.getSelectionModel().getSelectedItem());
        setDataToTableViewObservableList.remove(index2.get());
        //showTableView.getSelectionModel().clearSelection();

        setDataToTableview();

    }
}
