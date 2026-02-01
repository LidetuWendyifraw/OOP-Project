package edu.aau.gui;

import edu.aau.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class FlightTicketingGUI extends Application {

    private final edu.aau.FlightRepository flightRepository = new edu.aau.FlightRepository();
    private final ObservableList<Flight> searchResults = FXCollections.observableArrayList();
    private final ObservableList<Flight> bookedFlights = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(
                createSearchTab(),
                createBookingTab(),
                createManageTab()
        );

        Scene scene = new Scene(tabPane, 800, 500);
        stage.setTitle("Flight Ticketing System");
        stage.setScene(scene);
        stage.show();
    }

    /* ---------------- SEARCH FLIGHTS ---------------- */
    private Tab createSearchTab() {
        TextField fromField = new TextField();
        TextField toField = new TextField();
        Button searchBtn = new Button("Search Flights");

        TableView<edu.aau.Flight> table = createFlightTable(searchResults);

        searchBtn.setOnAction(e -> {
            searchResults.clear();
            try {
                for (Flight f : flightRepository.getAllFlights()) {
                    if (f.getOrigin().equalsIgnoreCase(fromField.getText())
                            && f.getDestination().equalsIgnoreCase(toField.getText())) {
                        searchResults.add(f);
                    }
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.addRow(0, new Label("From:"), fromField);
        form.addRow(1, new Label("To:"), toField);
        form.add(searchBtn, 1, 2);

        VBox layout = new VBox(15, form, table);
        layout.setPadding(new Insets(15));

        return new Tab("Search Flights", layout);
    }

    /* ---------------- BOOK FLIGHT ---------------- */
    private Tab createBookingTab() {
        TableView<Flight> table = createFlightTable(searchResults);
        Button bookBtn = new Button("Book Selected Flight");

        bookBtn.setOnAction(e -> {
            Flight selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                bookedFlights.add(selected);
                new Alert(Alert.AlertType.INFORMATION, "Flight booked successfully").show();
            }
        });

        VBox layout = new VBox(15, table, bookBtn);
        layout.setPadding(new Insets(15));

        return new Tab("Book Flight", layout);
    }

    /* ---------------- VIEW & CANCEL BOOKINGS ---------------- */
    private Tab createManageTab() {
        TableView<Flight> table = createFlightTable(bookedFlights);
        Button cancelBtn = new Button("Cancel Booking");

        cancelBtn.setOnAction(e -> {
            Flight selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                bookedFlights.remove(selected);
                new Alert(Alert.AlertType.INFORMATION, "Booking cancelled").show();
            }
        });

        VBox layout = new VBox(15, table, cancelBtn);
        layout.setPadding(new Insets(15));

        return new Tab("My Bookings", layout);
    }

    /* ---------------- TABLE FACTORY ---------------- */
    private TableView<Flight> createFlightTable(ObservableList<Flight> data) {
        TableView<Flight> table = new TableView<>(data);

        TableColumn<Flight, String> fromCol = new TableColumn<>("From");
        fromCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getOrigin()));

        TableColumn<Flight, String> toCol = new TableColumn<>("To");
        toCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDestination()));

        TableColumn<Flight, String> idCol = new TableColumn<>("Flight ID");
        idCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getFlightNumber()));

        table.getColumns().addAll(idCol, fromCol, toCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return table;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

