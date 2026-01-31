package edu.aau;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class BookingFileRepository implements BookingRepository {
    private final String filePath = "data/tickets.dat";
    private List<Ticket> tickets;

    public BookingFileRepository() {
        tickets = loadTickets();
    }

    private List<Ticket> loadTickets() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Ticket>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveTicketsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(tickets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTicket(Ticket ticket) {
        tickets.add(ticket);
        saveTicketsToFile();
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        for (Ticket t : tickets) {
            if (t.getTicketId().equals(ticketId)) return t;
        }
        return null;
    }

    @Override
    public List<Ticket> getTicketsByPassenger(String passengerId) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.getPassengerId().equals(passengerId)) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public void deleteTicket(String ticketId) {
        tickets.removeIf(t -> t.getTicketId().equals(ticketId));
        saveTicketsToFile();
    }
}

