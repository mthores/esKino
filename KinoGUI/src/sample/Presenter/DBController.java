package sample.Presenter;


import javafx.collections.ObservableList;
import sample.Model.Film;
import sample.View.ShowManagementController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Mikkel on 27/09/2016.
 */
public class DBController {

    //gets movies from db and adds to show management
    public void getMovieFromDB(){
        Connection conn;

        try{
            conn = DBConnection.getConnection();
            String sql = "Select Film_title from Film";
            ResultSet rsl = conn.createStatement().executeQuery(sql);

            ShowManagementController.setDataToComboxObservableList.clear();

            while(rsl.next()){
                ShowManagementController.setDataToComboxObservableList.add(new Film(
                        rsl.getString("Film_title")
                ));
            }
            rsl.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void writeToShowsDB(){

    }

}
