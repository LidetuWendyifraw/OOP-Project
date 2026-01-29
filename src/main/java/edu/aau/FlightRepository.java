package edu.aau;
import java.io.*;
import java.util.*;

public class FlightRepository {



        private static final String FILE_NAME = "flights.txt";

        public static List<Flight> getAllFlights() throws IOException {
            List<Flight> flights = new ArrayList<>();
            File file = new File(FILE_NAME);
            if (!file.exists()) return flights;

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(":");
                    flights.add(new Flight(
                            data[0], data[1], data[2],
                            Integer.parseInt(data[3]), data[4]
                    ));
                }
            }
            return flights;
        }

        public static void saveAllFlights(List<Flight> flights) throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Flight f : flights) {
                    bw.write(f.toString());
                    bw.newLine();
                }
            }
}}
