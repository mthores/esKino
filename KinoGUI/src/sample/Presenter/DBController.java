package sample.Presenter;
import sample.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import sample.Model.Film;
import sample.View.LoginSalMainmenuController;
import sample.View.ShowManagementController;

import java.sql.ResultSet;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

<<<<<<< HEAD


/**
 * Created by Mikkel on 27/09/2016.
 */
=======
>>>>>>> 226421eb40c43430c9805436fb7f04acf357623a
public class DBController {


    public static ArrayList readShowToSeats(int showId) {

        Connection connection = null;

<<<<<<< HEAD
=======


>>>>>>> 6c152c5e9c6f10f2962756949dde6c5fd7e2ec1d
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

<<<<<<< HEAD
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
=======
            System.out.println("success");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
>>>>>>> 6c152c5e9c6f10f2962756949dde6c5fd7e2ec1d
                }
            }
        }
        return seats;
    }

<<<<<<< HEAD
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

=======
<<<<<<< HEAD
        public static void writeReservations(Shows show, Customer customer, String seat_id) {
            try {
                String sqlString = "INSERT INTO Reservation (reservation_id, Film_title, Customer_id, shows_id, seat_id)" +
                        "VALUES (DEFAULT , ?, ?, ?, ?, ?)";

                PreparedStatement prepared = DBConnection.getConnection().prepareStatement(sqlString);

                prepared.setString(2, show.getMovieTitel());
                prepared.setString(3, customer.getPhoneNumber());
                prepared.setInt(4, show.getID());
                prepared.setString(5, seat_id);
=======
>>>>>>> 6c152c5e9c6f10f2962756949dde6c5fd7e2ec1d
    public static void writeReservations(Shows show, Customer customer, String seat_id) {
        try {
            String sqlString = "INSERT INTO Reservation (reservation_id, Film_title, Customer_id, shows_id, seat_id)" +
                    "VALUES (DEFAULT , ?, ?, ?, ?, ?)";

            PreparedStatement prepared = DBConnection.getConnection().prepareStatement(sqlString);
>>>>>>> 41dc6dcac4696b9826364841abfba79ebdc15d23

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

<<<<<<< HEAD
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

    public void buildDataShowManagement(Shows shows){

=======
    }

    //gets movies from db and adds to show management
<<<<<<< HEAD
    public void getMovieFromDB() {
=======
    public void getMovieFromDB(){
>>>>>>> 41dc6dcac4696b9826364841abfba79ebdc15d23
>>>>>>> 226421eb40c43430c9805436fb7f04acf357623a
        Connection conn;
        PreparedStatement ps;
        String sql = "Insert Into Shows (shows_Id, movie_Title, cinema_Hall, Date, Time) Values (default, ?, ?, ?, ?)";

<<<<<<< HEAD
        try {
=======
        try{

>>>>>>> 226421eb40c43430c9805436fb7f04acf357623a
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, shows.getMovieTitel());
            ps.setInt(2, shows.getCinemaHall());
            ps.setString(3, shows.getDate());
            ps.setString(4, shows.getTime());

            ps.executeUpdate();

<<<<<<< HEAD
            while (rsl.next()) {
                ShowManagementController.setDataToComboxObservableList.add(new Film(
                        rsl.getString("Film_title")
=======
            ps.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
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
>>>>>>> 226421eb40c43430c9805436fb7f04acf357623a
                ));
            }
            rs.close();
            conn.close();

<<<<<<< HEAD
        } catch (Exception e) {
=======
        }catch (Exception e){
>>>>>>> 226421eb40c43430c9805436fb7f04acf357623a
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    //Checking login info from the DB
    public static boolean loginCheck() {

        Connection conn;
        boolean check = false;

        try {
            conn = DBConnection.getConnection();

            Statement mystate = conn.createStatement();

            ResultSet rs = mystate.executeQuery("Select * Where "
                    + "Login_name"
                    + "="
                    + LoginSalMainmenuController.username.getText());

            if (rs.next()) {
               String Login_Name = rs.getString("Login_name");
                System.out.println(Login_Name);
                return true;

            } else {
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        return check;

    }
=======
=======
>>>>>>> 41dc6dcac4696b9826364841abfba79ebdc15d23
>>>>>>> 226421eb40c43430c9805436fb7f04acf357623a
}
