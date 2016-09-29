package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CinemaHall {

    private SimpleIntegerProperty hallNumber;
    private SimpleStringProperty row;
    private SimpleIntegerProperty seat;



    //constructor
    public CinemaHall(int hallNumber, String row, int seat) {
        this.hallNumber = new SimpleIntegerProperty(hallNumber);
        this.row = new SimpleStringProperty(row);
        this.seat = new SimpleIntegerProperty(seat);
    }

    //setter & getter
    public int getHallNumber() {
        return hallNumber.get();
    }

    public SimpleIntegerProperty hallNumberProperty() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber.set(hallNumber);
    }

    public String getRow() {
        return row.get();
    }

    public SimpleStringProperty rowProperty() {
        return row;
    }

    public void setRow(String row) {
        this.row.set(row);
    }

    public int getSeat() {
        return seat.get();
    }

    public SimpleIntegerProperty seatProperty() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat.set(seat);
    }
}
