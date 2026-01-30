package edu.aau.repository;

import edu.aau.model.Flight;
import edu.aau.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    public void addFlight(Flight flight) throws Exception {
        String sql = "INSERT INTO flights(flight_number, origin, destination, price, seats) VALUES(?,?,?,?,?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, flight.getFlightNumber());
            ps.setString(2, flight.getOrigin());
            ps.setString(3, flight.getDestination());
            ps.setDouble(4, flight.getPrice());
            ps.setInt(5, flight.getSeats());
            ps.executeUpdate();
        }
    }

    public List<Flight> getAllFlights() throws Exception {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                flights.add(new Flight(
                        rs.getString("flight_number"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getDouble("price"),
                        rs.getInt("seats")
                ));
            }
        }
        return flights;
    }
}

