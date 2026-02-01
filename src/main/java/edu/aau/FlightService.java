package edu.aau;
import java.io.IOException;
import java.util.*;

public class FlightService {

    public void addFlight(Flight flight) throws Exception {
        List<Flight> flights = FlightRepository.getAllFlights();
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flight.getFlightNumber())) {
                throw new IllegalArgumentException("Flight already exists");
            }
        }
        flights.add(flight);
        FlightRepository.saveAllFlights(flights);
    }

    public List<Flight> viewFlights() throws Exception {
        return FlightRepository.getAllFlights();
    }

    public void updateFlight(String flightNumber, Flight updatedFlight) throws Exception {
        List<Flight> flights = FlightRepository.getAllFlights();
        boolean found = false;

        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNumber)) {
                f.setOrigin(updatedFlight.getOrigin());
                f.setDestination(updatedFlight.getDestination());

                found = true;
                break;
            }
        }

        if (!found) throw new IllegalArgumentException("Flight not found");
        FlightRepository.saveAllFlights(flights);
    }

    public void deleteFlight(String flightNumber) throws Exception {
        List<Flight> flights = FlightRepository.getAllFlights();
        flights.removeIf(f -> f.getFlightNumber().equals(flightNumber));
        FlightRepository.saveAllFlights(flights);
    }

    public List<Flight> searchFlights(String keyword) throws Exception {
        List<Flight> result = new ArrayList<>();
        for (Flight f : FlightRepository.getAllFlights()) {
            if (f.getOrigin().toLowerCase().contains(keyword.toLowerCase()) ||
                    f.getDestination().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(f);
            }
        }
        return result;
    }
}

