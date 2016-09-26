package sample.Model;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {

    private SimpleStringProperty phoneNumber;


    //contructor

    public Customer(String phoneNumber) {
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }


    // setter & getter

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
}
