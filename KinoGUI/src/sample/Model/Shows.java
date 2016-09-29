package sample.Model;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;



public class Shows {

    private SimpleStringProperty movieTitel;
    private SimpleIntegerProperty cinemaHall;
    private SimpleStringProperty date;
    private SimpleStringProperty time;
    private SimpleIntegerProperty id;


    //constructor
    public Shows(String movieTitel, int cinemaHall, String date, String time, int id) {
        this.movieTitel = new SimpleStringProperty(movieTitel);
        this.cinemaHall = new SimpleIntegerProperty(cinemaHall);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.id = new SimpleIntegerProperty(id);
    }

    //constructor
    public Shows(String movieTitel, int cinemaHall, String date, String time) {
        this.movieTitel = new SimpleStringProperty(movieTitel);
        this.cinemaHall = new SimpleIntegerProperty(cinemaHall);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
    }

    //getter & setter
    public String getMovieTitel() {
        return movieTitel.get();
    }

    public SimpleStringProperty movieTitelProperty() {
        return movieTitel;
    }

    public void setMovieTitel(String movieTitel) {
        this.movieTitel.set(movieTitel);
    }

    public int getCinemaHall() {
        return cinemaHall.get();
    }

    public SimpleIntegerProperty cinemaHallProperty() {
        return cinemaHall;
    }

    public void setCinemaHall(int cinemaHall) {
        this.cinemaHall.set(cinemaHall);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public int getID() { return id.get();}
}
