package sample.Presenter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Mikkel on 27/09/2016.
 */
public class DBConnection {

        private static int iPort = 3306;

        public static Connection getConnection(){
            Connection connection = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7137771", "sql7137771", "c8UcTPxHlK");
                System.out.println("Succesfully connected");

            } catch(Exception e){
                e.printStackTrace();
            }

            return connection;
        }

}

