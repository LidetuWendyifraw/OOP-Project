package edu.aau;
import java.util.List;
public interface BookingRepository {
    void saveTicket(Ticket ticket);
    Ticket getTicketById(String ticketId);
    List<Ticket> getTicketsByPassenger(String passengerId);
    void deleteTicket(String ticketId);
}
