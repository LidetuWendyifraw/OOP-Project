package edu.aau;
import java.util.List;
public class BookingServiceImpl implements BookingService {
    private BookingRepository repository;

    public BookingServiceImpl(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean bookTicket(String passengerId, String flightId, int seatNumber) {
        // check if the seat is already booked for this flight
        List<Ticket> tickets = repository.getTicketsByPassenger(passengerId);
        for (Ticket t : tickets) {
            if (t.getFlightId().equals(flightId) && t.getSeatNumber() == seatNumber) {
                return false; // already booked
            }
        }

        String ticketId = passengerId + "_" + flightId + "_" + seatNumber;
        Ticket ticket = new Ticket(ticketId, passengerId, flightId, seatNumber);
        repository.saveTicket(ticket);
        return true;
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        Ticket t = repository.getTicketById(ticketId);
        if (t != null) {
            repository.deleteTicket(ticketId);
            return true;
        }
        return false;
    }

    @Override
    public List<Ticket> viewPassengerTickets(String passengerId) {
        return repository.getTicketsByPassenger(passengerId);
    }
}
