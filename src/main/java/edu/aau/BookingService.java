package edu.aau;
import java.util.List;
public interface BookingService {
    boolean bookTicket(String passengerId, String flightId, int seatNumber);
    boolean cancelTicket(String ticketId);
    List<Ticket> viewPassengerTickets(String passengerId);
}
