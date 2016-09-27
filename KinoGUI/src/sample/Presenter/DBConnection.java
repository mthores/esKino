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
                connection = DriverManager.getConnection("jdbc:mysql://db4free.net"+iPort+"/mydb?useSSL=false", "kino_gruppe", "kea2016");

            } catch(Exception e){
                e.printStackTrace();
            }

            return connection;
        }

}

