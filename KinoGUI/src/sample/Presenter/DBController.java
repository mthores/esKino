package sample.Presenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Model.*;

import java.sql.*;

import sample.Model.Film;
import sample.View.LoginSalMainmenuController;
import sample.View.ShowManagementController;

import javafx.scene.shape.Rectangle;
import sun.rmi.runtime.Log;

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

    public static ObservableList<String> readMovieTitles() {

        Connection connection = null;

        Statement statement = null;
        String sqlQuery = "SELECT Film_title FROM Film;";

        ResultSet resultSet = null;

        ObservableList<String> movieTitles = FXCollections.observableArrayList();


        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                String temp = resultSet.getString("Film_title");
                movieTitles.add(temp);

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
        return movieTitles;
    }

    public static ObservableList<Shows> readShowsOfMovie(String movieTitle) {

        Connection connection = null;

        Statement statement = null;
        String sqlQuery = "SELECT * FROM Shows WHERE movie_Title = '" + movieTitle + "' ORDER BY Date;";

        ResultSet resultSet = null;

        ObservableList<Shows> shows = FXCollections.observableArrayList();


        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                String movieTitel = resultSet.getString("movie_Title");
                int cinemaHall = resultSet.getInt("cinema_Hall");
                String date = resultSet.getString("Date");
                String time = resultSet.getString("Time");
                int id = resultSet.getInt("shows_Id");


                Shows tempShow = new Shows(movieTitel, cinemaHall, date, time, id);
                shows.add(tempShow);

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
        return shows;
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


    public static void writeReservations(int show, String customer, String seat_id, String movie_title){
        Connection connection = null;

        PreparedStatement statement = null;

        ResultSet resultSet = null;

        ArrayList<Rectangle> seats = new ArrayList();

        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("INSERT INTO Reservation (`Film_title`, `Customer_id`, `shows_Id`, `seat_Id`) " +
                    "VALUES ('"+movie_title+"', '"+customer+"', '"+show+"', '"+seat_id+"');");

            statement.execute();

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

    public void buildDataShowManagement(Shows shows) {

        Connection conn;
        PreparedStatement ps;
        String sql = "Insert Into Shows (shows_Id, movie_Title, cinema_Hall, Date, Time) Values (default, ?, ?, ?, ?)";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, shows.getMovieTitel());
            ps.setInt(2, shows.getCinemaHall());
            ps.setString(3, shows.getDate());
            ps.setString(4, shows.getTime());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
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


    //Checking login info from the DB
    public static boolean loginCheck(String tF,String pF) {


        Connection conn;
        String Login_Name = "";
        String Login_Password = "";
        boolean check = false;
        String name = tF;
        String password = pF;


        try {
            conn = DBConnection.getConnection();

            Statement mystate = conn.createStatement();

            ResultSet rs = mystate.executeQuery
                    ("Select * FROM Login WHERE Login_name = '"+name+"'");


            while(rs.next()) {
                Login_Name = rs.getString("Login_name");
                Login_Password = rs.getString("Login_pass");


            }
            if (name.equals(Login_Name)&& password.equals(Login_Password) ){
                check= true;

            } else {
                check = false;
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        return check;

    }

    public void readInfoToFilm(){


        Connection conn;

        LoginSalMainmenuController.filmObservableList.clear();

        try{
            conn = DBConnection.getConnection();
            String sql = "Select Film_title, Duration,Genre, Rating, Tickets_sold, Timestamp from Film";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()){
                LoginSalMainmenuController.filmObservableList.add(new Film(
                rs.getString("Film_title"),
                rs.getString("Duration"),
                rs.getString("Genre"),
                rs.getString("Rating"),
                rs.getInt("Tickets_Sold"),
                rs.getDate("Timestamp")));
            }
            rs.close();
            conn.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void buildDataFilm(Film film) {

        Connection conn;
        PreparedStatement ps;
        String sql = "Insert Into Film (Film_title, Description, Ticket_price, Duration, Genre, Rating, License_price, Timestamp) Values (?, ?, ?, ?, ?, ?, ?, CURRENT_DATE)";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, film.getTitel());
            ps.setString(2, film.getDescription());
            ps.setInt(3, film.getTicketPrice());
            ps.setString(4, film.getDuration());
            ps.setString(5, film.getGenre());
            ps.setString(6, film.getRating());
            ps.setInt(7, film.getLicensPrice());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletedFromFilm(Object film){
        Film selectedFilm = (Film) film;

        Connection conn;
        PreparedStatement pre;
        String sql = "Delete from Film where Film_title = ?";

        try{
            conn = DBConnection.getConnection();
            pre = conn.prepareStatement(sql);

            pre.setString(1,selectedFilm.getTitel());

            pre.execute();
            pre.close();
            conn.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void deletedFromShowMangement (Object show){
        Shows selectedMovie = (Shows) show;

        Connection conn;
        PreparedStatement pre;
        String sql = "Delete from Shows where movie_Title = ? AND cinema_hall = ? AND Date = ? AND Time = ?";

        try{
            conn = DBConnection.getConnection();
            pre = conn.prepareStatement(sql);

            pre.setString(1,selectedMovie.getMovieTitel());
            pre.setInt(2, selectedMovie.getCinemaHall());
            pre.setDate(3, Date.valueOf(selectedMovie.getDate()));
            pre.setString(4,selectedMovie.getTime());

            pre.execute();
            pre.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static int getIdFromUserInfo (String name, String date, String time) {

        Connection connection = null;

        Statement statement = null;
        String sqlQuery = "SELECT shows_Id FROM Shows WHERE movie_title = '"+ name+ "' AND Date = '"+ date +"' AND Time = '"+ time +"';";

        int showId = 0;

        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                showId = resultSet.getInt("shows_Id");

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
        return showId;
    }

}
