package edu.aau;
import java.io.Serializable;
import java.time.LocalDateTime;
public class Ticket implements Serializable{
    private String ticketId;
    private String passengerId;
    private String flightId;
    private int seatNumber;
    private LocalDateTime bookingTime;

    public Ticket(String ticketId, String passengerId, String flightId, int seatNumber) {
        this.ticketId = ticketId;
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
    }

    public String getTicketId() { return ticketId; }
    public String getPassengerId() { return passengerId; }
    public String getFlightId() { return flightId; }
    public int getSeatNumber() { return seatNumber; }
    public LocalDateTime getBookingTime() { return bookingTime; }

    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", seatNumber=" + seatNumber +
                ", bookingTime=" + bookingTime +
                '}';
    }
}

