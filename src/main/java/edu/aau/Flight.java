package edu.aau;
import java.io.Serializable;
public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private double price;
    private int seats;

    public Flight(String flightNumber, String origin, String destination, double price, int seats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.seats = seats;
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





    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }


    @Override
    public String toString() {
        return flightNumber + ":" + origin + ":" + destination ;
    }
}
//this my test commit on thefligh class
