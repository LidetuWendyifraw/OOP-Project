package edu.aau;
import java.io.Serializable;
public class Flight implements Serializable {
    private String flightNumber;
    private String origin;
    private String destination;
    private int seatsAvailable;
    private String departureTime;


    public Flight(String flightNumber, String origin, String destination, int seatsAvailable, String departureTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
        this.departureTime = departureTime;
    }


    public String getFlightNumber() {
        return flightNumber;
    }


    public String getOrigin() {
        return origin;
    }


    public String getDestination() {
        return destination;
    }


    public int getSeatsAvailable() {
        return seatsAvailable;
    }


    public String getDepartureTime() {
        return departureTime;
    }


    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }


    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }


    @Override
    public String toString() {
        return flightNumber + ":" + origin + ":" + destination + ":" + seatsAvailable + ":" + departureTime;
    }
}
//this my test commit on thefligh class