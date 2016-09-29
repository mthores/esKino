package sample.Presenter;
import sample.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import sample.Model.Film;
import sample.View.ShowManagementController;

import java.sql.ResultSet;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class DBController {


    public static ArrayList readShowToSeats(int showId) {

        Connection connection = null;

        Statement statement = null;
        String sqlQuery = "SELECT * FROM Reservation WHERE shows_Id = '" + showId + "';";

        ResultSet resultSet = null;

        ArrayList<Rectangle> seats = new ArrayList();

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                String temp = resultSet.getString("seat_Id");
                Rectangle getRect = new Rectangle();
                getRect.setId(temp);

                seats.add(getRect);

            }

            System.out.println("success");

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
        public void getMovieFromDB() {
            Connection conn;

            try {
                conn = DBConnection.getConnection();
                String sql = "Select Film_title from Film";
                ResultSet rsl = conn.createStatement().executeQuery(sql);

                ShowManagementController.setDataToComboxObservableList.clear();

                while (rsl.next()) {
                    ShowManagementController.setDataToComboxObservableList.add(new Film(
                            rsl.getString("Film_title")
                    ));
                }
                rsl.close();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    //gets movies from db and adds to show management
    public void buildDataShowManagement(Shows shows){
        Connection conn;
        PreparedStatement ps;
        String sql = "Insert Into Shows (shows_Id, movie_Title, cinema_Hall, Date, Time) Values (default, ?, ?, ?, ?)";

        try{

            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, shows.getMovieTitel());
            ps.setInt(2, shows.getCinemaHall());
            ps.setString(3, shows.getDate());
            ps.setString(4, shows.getTime());

            ps.executeUpdate();

            ps.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void refreshTableview(){

        Connection conn;

        try{

            conn = DBConnection.getConnection();
            String sql = "Select movie_Title, cinema_Hall, Date, Time From Shows";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            //deletes old data and gets fresh data from db
            ShowManagementController.setDataToTableViewObservableList.clear();

            //set all the data from db into an ObservableList
            while(rs.next()){
                ShowManagementController.setDataToTableViewObservableList.add(new Shows(
                rs.getString("movie_Title"),
                rs.getInt("cinema_Hall"),
                rs.getString("Date"),
                rs.getString("Time")
                ));
            }
            rs.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
