package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Film {

    private SimpleIntegerProperty id;
    private SimpleStringProperty titel;
    private SimpleStringProperty description;
    private SimpleIntegerProperty ticketPrice;
    private SimpleStringProperty duration;
    private SimpleStringProperty genre;
    private SimpleStringProperty rating;
    private SimpleIntegerProperty licensPrice;
    private SimpleIntegerProperty ticketSold;
    private SimpleIntegerProperty hall;
    private Date timestamp;


    //contructor
    public Film(String titel, String description, int ticketPrice, String duration,
                String genre, String rating, int licensPrice, int ticketSold, int hall, int id) {

        this.titel = new SimpleStringProperty(titel);
        this.description = new SimpleStringProperty(description);
        this.ticketPrice = new SimpleIntegerProperty(ticketPrice);
        this.duration = new SimpleStringProperty (duration);
        this.genre = new SimpleStringProperty (genre);
        this.rating = new SimpleStringProperty (rating);
        this.licensPrice = new SimpleIntegerProperty(licensPrice);
        this.ticketSold = new SimpleIntegerProperty(ticketSold);
        this.hall = new SimpleIntegerProperty(hall);
        this.id = new SimpleIntegerProperty(id);
    }

    //Til at skrive til DB Film
    public Film(String titel, String description, int ticketPrice,
                String duration, String genre, String rating, int licensPrice, Date timestamp) {
        this.titel = new SimpleStringProperty(titel);
        this.description = new SimpleStringProperty(description);
        this.ticketPrice = new SimpleIntegerProperty(ticketPrice);
        this.duration = new SimpleStringProperty(duration);
        this.genre = new SimpleStringProperty(genre);
        this.rating = new SimpleStringProperty(rating);
        this.licensPrice = new SimpleIntegerProperty(licensPrice);
        this.timestamp = timestamp;
    }

    //Også til at skrive til DB Film
    public Film(String titel, String description, int ticketPrice,
                String duration, String genre, String rating, int licensPrice) {
        this.titel = new SimpleStringProperty(titel);
        this.description = new SimpleStringProperty(description);
        this.ticketPrice = new SimpleIntegerProperty(ticketPrice);
        this.duration = new SimpleStringProperty(duration);
        this.genre = new SimpleStringProperty(genre);
        this.rating = new SimpleStringProperty(rating);
        this.licensPrice = new SimpleIntegerProperty(licensPrice);
    }

    public Film(String titel, String duration, String genre, String rating, int ticketSold, Date timestamp){
        this.titel = new SimpleStringProperty(titel);
        this.duration = new SimpleStringProperty (duration);
        this.genre = new SimpleStringProperty (genre);
        this.rating = new SimpleStringProperty (rating);
        this.ticketSold = new SimpleIntegerProperty(ticketSold);
        this.timestamp = timestamp;
    }

    public Film(String titel) {
        this.titel = new SimpleStringProperty(titel);
    }

    //setter & setters
    public String getTitel() {
        return titel.get();
    }

    public SimpleStringProperty titelProperty() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel.set(titel);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getTicketPrice() {
        return ticketPrice.get();
    }

    public SimpleIntegerProperty ticketPriceProperty() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice.set(ticketPrice);
    }

    public String getDuration() {
        return duration.get();
    }

    public SimpleStringProperty durationProperty() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    public String getGenre() {
        return genre.get();
    }

    public SimpleStringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getRating() {
        return rating.get();
    }

    public SimpleStringProperty ratingProperty() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

    public int getLicensPrice() {
        return licensPrice.get();
    }

    public SimpleIntegerProperty licensPriceProperty() {
        return licensPrice;
    }

    public void setLicensPrice(int licensPrice) {
        this.licensPrice.set(licensPrice);
    }

    public int getTicketSold() {
        return ticketSold.get();
    }

    public SimpleIntegerProperty ticketSoldProperty() {
        return ticketSold;
    }

    public void setTicketSold(int ticketSold) {
        this.ticketSold.set(ticketSold);
    }

    public int getHall() {
        return hall.get();
    }

    public SimpleIntegerProperty hallProperty() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall.set(hall);
    }


    public  int getID() {
        return id.get();
    }

    //work with titel!!!!
    public String toString() {
        return getTitel();
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
