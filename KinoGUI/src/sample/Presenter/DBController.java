package sample.Presenter;
import sample.Model.*;
import sample.Presenter.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mikkel on 27/09/2016.
 */
public class DBController {

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
}
