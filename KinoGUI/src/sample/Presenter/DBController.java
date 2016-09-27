package sample.Presenter;

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


}
