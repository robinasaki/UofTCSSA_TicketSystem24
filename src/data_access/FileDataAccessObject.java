package data_access;

import Exceptions.DuplicateNameException;
import entity.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataAccessObject {
    private static final String FILE_PATH = "tickets.ser";

    public FileDataAccessObject() {

    }

    // load all tickets in the dataset
    public static List<Ticket> loadTickets() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Ticket>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // save one ticket
    public void saveTicket(Ticket ticket) throws DuplicateNameException {
        List<Ticket> ticketList = loadTickets();
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getBuyerName().equals(ticket.getBuyerName())) {
                throw new DuplicateNameException("Warning: duplicate name found.");
            }
        }
    }

    // save several tickets
    public void saveTickets(List<Ticket> ticketList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(ticketList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
