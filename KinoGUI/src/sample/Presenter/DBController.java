package sample.Presenter;
import sample.Model.*;
import sample.Presenter.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import javafx.collections.ObservableList;
import sample.Model.Film;
import sample.View.ShowManagementController;

import java.sql.Connection;
import java.sql.ResultSet;

import javafx.scene.shape.Rectangle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static sample.Presenter.DBConnection.getConnection;

/**
 * Created by Mikkel on 27/09/2016.
 */
public class DBController {


    public static ArrayList readShowToSeats(int showId){

        Connection connection = null;

        Statement statement = null;
        String sqlQuery = "SELECT * FROM Reservation WHERE shows_Id = '"+showId+"';";

        ResultSet resultSet = null;

        ArrayList<Rectangle> seats = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                String temp = resultSet.getString("seat_Id");
                Rectangle getRect = new Rectangle();
                getRect.setId(temp);

                seats.add(getRect);

            }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        return seats;
    }

    public static int getPriceFromMovie(String movieName){

        Connection connection = null;

        Statement statement = null;
        String sqlQuery = "SELECT Ticket_price FROM Film WHERE Film_title = '"+movieName+"';";
        int price = 0;

        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                price = resultSet.getInt("Ticket_price");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return price;
    }

    public static void writeReservations(Shows show, Customer customer, String seat_id) {
        try {
            String sqlString = "INSERT INTO Reservation (reservation_id, Film_title, Customer_id, shows_id, seat_id)" +
                    "VALUES (DEFAULT , ?, ?, ?, ?, ?)";

            PreparedStatement prepared = DBConnection.getConnection().prepareStatement(sqlString);

            prepared.setString(2, show.getMovieTitel());
            prepared.setString(3, customer.getPhoneNumber());
            prepared.setInt(4, show.getID());
            prepared.setString(5, seat_id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateSoldTickets(Film film, int tickets) {

        try {
            Statement statement = DBConnection.getConnection().createStatement();

            String sqlString = "UPDATE sql7137771.Film SET Tickets_Sold = " +
                    tickets + " WHERE Film_title = " + film.getTitel() + ";";

            statement.executeUpdate(sqlString);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

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

}
