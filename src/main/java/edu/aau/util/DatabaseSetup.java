package edu.aau.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {

            String flightTable = """
                    CREATE TABLE IF NOT EXISTS flights(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        flight_number TEXT,
                        origin TEXT,
                        destination TEXT,
                        price REAL,
                        seats INTEGER
                    );
                    """;

            String bookingTable = """
                    CREATE TABLE IF NOT EXISTS bookings(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        flight_number TEXT,
                        passenger_name TEXT
                    );
                    """;

            stmt.execute(flightTable);
            stmt.execute(bookingTable);

            System.out.println("Database tables created!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

