package sample.View;

import javafx.animation.PauseTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableRow;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Model.Shows;
import sample.Model.Film;
import sample.Presenter.DBController;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;


//import java.io.IOException;

public class LoginSalMainmenuController {

    ShowManagementController showManagementController = new ShowManagementController();

    private static MouseEvent e;
    public static Stage mainStage;
    //@FXML public static TextField username;
    //@FXML public static PasswordField password;

    @FXML
    private Label infoLabelCinema;
    @FXML
    private Label ticketCount;
    @FXML
    private Label totalPrice;
    private int tC;
    private int ticketPrice;


    public static void initializeController(Stage stage) {
        mainStage = stage;
    }

    public void loginButtonClicked() throws IOException {

        TextField tF = (TextField) mainStage.getScene().getRoot().lookup("#username");
        TextField pF = (TextField) mainStage.getScene().getRoot().lookup("#password");

        if (true == DBController.loginCheck(tF.getText(), pF.getText())) {
            System.out.println("logged in succesfully!");

            toMenuButtonClicked();


        } else {
            tF.clear();
            pF.clear();
            System.out.println("login failed.");
        }
    }

    public void logOffButtonClicked() throws IOException {

        Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginScene = new Scene(loginParent);
        mainStage.setScene(loginScene);
    }

    public void reservationMenuClicked() throws IOException {

        Parent reservationParent = FXMLLoader.load(getClass().getResource("reservationsside.fxml"));
        Scene reservationScene = new Scene(reservationParent);
        mainStage.setScene(reservationScene);

        //Movie ComboBox
        ComboBox cbTitles = (ComboBox) reservationParent.getScene().getRoot().lookup("#movieCB");
        ObservableList<String> movieTitles = DBController.readMovieTitles();
        cbTitles.setItems(movieTitles);


        //Show ComboBox
        ComboBox cbShows = (ComboBox) reservationParent.getScene().getRoot().lookup("#showCB");
        cbShows.setDisable(true);

        cbTitles.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                cbShows.setDisable(false);

            }
        });

        cbShows.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Label warningLabel = (Label) reservationParent.getScene().getRoot().lookup("#warninglabel");

                if (cbTitles.getSelectionModel().getSelectedItem() == null) {
                    warningLabel = (Label) reservationParent.getScene().getRoot().lookup("#warninglabel");
                    warningLabel.setText("Ingen film valgt");
                    cbShows.setDisable(true);

                } else {
                    warningLabel.setText("");
                    cbShows.setDisable(false);
                    System.out.println(cbTitles.getPromptText());

                    System.out.println(cbTitles.getSelectionModel().getSelectedItem().toString());
                    ObservableList<Shows> shows = DBController.readShowsOfMovie(cbTitles.getSelectionModel().getSelectedItem().toString());

                    ObservableList<String> showData = pullShowData(shows);

                    cbShows.setItems(showData);
                }
            }
        });

        Button reserveButton = (Button) reservationParent.getScene().getRoot().lookup("#reserveButton");

        reserveButton.setOnAction(e -> {

            try {
                if (cbShows.getSelectionModel().getSelectedItem() == null) {
                    Label warningLabel = (Label) reservationParent.getScene().getRoot().lookup("#warninglabel");
                    warningLabel.setText("Vælg venligst forestilling først");
                } else {
                    reserveButtonClicked(cbTitles.getSelectionModel().getSelectedItem().toString(), cbShows.getSelectionModel().getSelectedItem().toString());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });


    }


    public void toMenuButtonClicked() throws IOException {

        Parent mainMenuParent = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        Scene mainMenuScene = new Scene(mainMenuParent);
        mainStage.setScene(mainMenuScene);
    }

    public void reserveButtonClicked(String movie, String show) throws IOException {

        Parent cinemaParent = FXMLLoader.load(getClass().getResource("sal.fxml"));
        Scene cinemaScene = new Scene(cinemaParent);
        mainStage.setScene(cinemaScene);


        VBox rowBox = (VBox) cinemaParent.getScene().getRoot().lookup("#rowBox");
        ObservableList<Node> rowList = rowBox.getChildren();
        ObservableList<Node> seatList = FXCollections.observableArrayList();

        for (Node row : rowList) {

            HBox currentRow = (HBox) row;
           seatList.addAll(currentRow.getChildren());

        }

        //ObservableList<Node> seatList = seatBox.getChildren();

        String time = timeFromString(show);
        String date = dateFromString(show);

        int showId = DBController.getIdFromUserInfo(movie, date, time);
        initializeHall(seatList, showId);


        Button orderButton = (Button) cinemaParent.getScene().getRoot().lookup("#orderButton");

        orderButton.setOnAction(e -> {

            ArrayList<String> markedSeats = new ArrayList<String>();

            for (Node seat : seatList) {

                Rectangle rectSeat = (Rectangle) seat;

                if (rectSeat.getFill() == Color.DODGERBLUE) {
                    markedSeats.add(rectSeat.getId());
                }

            }
            String phoneNumber="";
            if(!markedSeats.isEmpty()) {
                phoneNumber = inputDialog();
            }

            for (String seat : markedSeats) {
                System.out.println(showId +" "+ phoneNumber + " " +seat);
                DBController.writeReservations(showId, phoneNumber, seat, movie);
                System.out.println("Virker det?");

            }



        });

    }

    public void toShowManagementButtonClicked() throws IOException {

        Parent showParent = FXMLLoader.load(getClass().getResource("ShowMangement.fxml"));
        Scene showScene = new Scene(showParent);
        mainStage.setScene(showScene);
    }

    public void addMovieMenuClicked() throws IOException {

        Parent addMovieParent = FXMLLoader.load(getClass().getResource("addMovie.fxml"));
        Scene addMovieScene = new Scene(addMovieParent);
        mainStage.setScene(addMovieScene);
    }

    public void redigereButtonClicked() throws IOException {

        Parent editMovieParent = FXMLLoader.load(getClass().getResource("EditMovie.fxml"));
        Scene editMovieScene = new Scene(editMovieParent);
        mainStage.setScene(editMovieScene);
    }

    public void cancelButtonClicked() throws IOException {

        Parent cancelParent = FXMLLoader.load(getClass().getResource("Film.fxml"));
        Scene cancelScene = new Scene(cancelParent);
        mainStage.setScene(cancelScene);
    }

    @FXML
    TableView<Film> tW2 = new TableView<>();


    public void administrationButtonClicked() throws IOException {
        Parent administrationParent = FXMLLoader.load(getClass().getResource("Film.fxml"));
        Scene administrationScene = new Scene(administrationParent);

        tW2.setRowFactory(tW2 -> {
            TableRow<Film> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Object rowData = row.getItem();
                    System.out.println(rowData);
                }
            });
            return row;
        });


        mainStage.setScene(administrationScene);

    }

    public void addMovieButtonClicked() throws IOException {
        Parent addMovieParent = FXMLLoader.load(getClass().getResource("View/AddMovieController.fxml"));
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


    public void seatClicked(MouseEvent e) {
        infoLabelCinema.setText("");
        Rectangle rect = (Rectangle) e.getSource();
        Paint rectColor = rect.getFill();
        String name = rect.getId();

        if (rectColor == Color.LIMEGREEN) {
            rect.setFill(Color.DODGERBLUE);
            tC++;
        }

        if (rectColor == Color.RED) {
            infoLabelCinema.setText("Sædet er optaget.");
        }


        if (rectColor == Color.DODGERBLUE) {
            rect.setFill(Color.LIMEGREEN);
            tC--;
        }

        if (ticketPrice == 0) {
            ticketPrice = DBController.getPriceFromMovie("Pochahotass");
        }

        updateTicketCounters(ticketPrice);

    }

    public void updateTicketCounters(int ticketPrice) {

        ticketCount.setText("" + tC);
        totalPrice.setText("" + tC * ticketPrice + " Kroner");
    }

    public void initializeHall(ObservableList<Node> seatList, int showId) {
        ArrayList<Rectangle> reservedSeats = DBController.readShowToSeats(showId);

        for (Rectangle rSeat : reservedSeats) {

            for (Node seat : seatList) {

                if (rSeat.getId().equals(seat.getId())) {
                    Rectangle redSeat = (Rectangle) seat;
                    redSeat.setFill(Color.RED);
                }
            }
        }
    }

    public ObservableList<String> pullShowData(ObservableList<Shows> oL) {

        ObservableList<String> dataListe = FXCollections.observableArrayList();

        for (Shows show : oL) {
            String data = "";
            data = show.getDate();
            data += " - kl. " + show.getTime();
            System.out.println(data);
            dataListe.add(data);
        }
        return dataListe;
    }


    @FXML
    private TableColumn<Film, String> TitelCol;
    @FXML
    private TableColumn<Film, Date> SidenCol;
    @FXML
    private TableColumn<Film, String> KategoriCol;
    @FXML
    private TableColumn<Film, String> SpilletidCol;
    @FXML
    private TableColumn<Film, String> RatingCol;
    @FXML
    private TableColumn<Film, Integer> SolgteCol;
    public static ObservableList<Film> filmObservableList = FXCollections.observableArrayList();

    public void refreshTableviewInFilm() {
        DBController dbController = new DBController();
        dbController.readInfoToFilm();

        TitelCol.setCellValueFactory(new PropertyValueFactory<>("titel"));
        SpilletidCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        KategoriCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
        RatingCol.setCellValueFactory(new PropertyValueFactory<Film, String>("rating"));
        SidenCol.setCellValueFactory(new PropertyValueFactory<Film, Date>("timestamp"));
        SolgteCol.setCellValueFactory(new PropertyValueFactory<Film, Integer>("ticketSold"));

        tW2.setItems(filmObservableList);

    }

    public void removeFilm() {
        SimpleIntegerProperty index = new SimpleIntegerProperty();

        DBController dbController = new DBController();

        dbController.deletedFromFilm(tW2.getSelectionModel().getSelectedItem());
        filmObservableList.remove(index.get());
        tW2.getSelectionModel().clearSelection();
    }

    public void editButtonClicked2() {

        try {
            redigereButtonClicked();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        tW2.setRowFactory(tv -> {
            TableRow tableRow = new TableRow();

            Film film = (Film) tW2.getSelectionModel().getSelectedItem();

            AddMovieController amc = new AddMovieController();

            amc.titelText.setText(film.getTitel());
            amc.descriptionArea.setText(film.getDescription());
            amc.durationText.setText(film.getDuration());
            amc.ticketPriceText.setText(Integer.toString(film.getTicketPrice()));
            amc.lincensPriceText.setText(Integer.toString(film.getLicensPrice()));
            amc.genreCombo.setValue(film.getGenre());
            amc.ratingCombo.setValue(film.getRating());

            return tableRow;
        });


    }

    public String timeFromString(String str) {
        String data = "";

        data = str.substring(str.lastIndexOf(' ') + 1);

        return data;
    }

    public String dateFromString(String str) {
        String data = "";

        data = str.substring(0, 10);

        return data;
    }

    public String inputDialog() {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Bekræft Reservation");
        dialog.setHeaderText("Bekræft Reservation");
        dialog.setContentText("Indtast venligst dit telefonnummer:");
        String stringResult ="";

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            stringResult = result.get();
            if (stringResult.length() == 8 ) {
                try {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Bekræftelse");
                    alert.setContentText("Dine billetter er nu reserveret. Husk at afhente dem senest 15 min før forestillingen.");

                    alert.showAndWait();

                    toMenuButtonClicked();
                } catch (Exception ex1) {
                    ex1.printStackTrace();
                }
            } else {
                inputDialog();
            }
        }
        return stringResult;
    }

}



