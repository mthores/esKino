package sample.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableRow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFilmAdmin {

    private static Stage mainStage;

    /*
    public void administrationButtonClicked() throws  IOException {
        Parent administrationParent = FXMLLoader.load(getClass().getResource("Film.fxml"));
        Scene administrationScene = new Scene(administrationParent);
        mainStage.setScene(administrationScene);
    }*/

    public void addMovieButtonClicked() throws IOException {
        Parent addMovieParent = FXMLLoader.load(getClass().getResource("View/addMovie.fxml"));
        Scene addMovieScene = new Scene(addMovieParent);
        mainStage.setScene(addMovieScene);
    }

    public void editMovieButtonClicked() throws IOException {
        //if (e.getSource() != null) {
        Parent editMovieParent = FXMLLoader.load(getClass().getResource("EditMovie.fxml"));
        Scene editMovieScene = new Scene(editMovieParent);
        mainStage.setScene(editMovieScene);
        //}
    }

    public Object mouseClickedMovie(MouseEvent e) {

        if (e.getSource() != null) {
            TableRow<Object> row = (TableRow<Object>) e.getSource();

            Object rowData = row.getItem();

            return rowData;
        } else {
            return null;
        }
    }
}


