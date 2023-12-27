package data_access;

import Exceptions.DuplicateNameException;
import entity.Ticket;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileDataAccessObject {
    private static final String FILE_PATH = "tickets.csv";

    public static List<Ticket> loadTickets() {
        List<Ticket> ticketList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Assuming your Ticket class has a constructor that takes the necessary fields
                Ticket ticket = new Ticket(parts[0], parts[1], parts[2], parts[3], LocalDate.parse(parts[4]));
                ticketList.add(ticket);
            }
        } catch (FileNotFoundException e) {
            // Handle file not found
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ticketList;
    }

//    public static List<Ticket> loadTickets() {
//        /**
//         * load all tickets in set
//         */
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
//            return (List<Ticket>) ois.readObject();
//        } catch (FileNotFoundException e) {
//            return new ArrayList<>();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
//    }

    public void saveTicket(Ticket ticket) throws DuplicateNameException {
        /**
         * save one ticket
         */

        List<Ticket> ticketList = loadTickets();
        for (int i = 0; i < ticketList.size(); i++) {
            // policy: no duplicate seat.
            if (ticketList.get(i).getSeat().equals(ticket.getSeat())) {
                throw new DuplicateNameException("Warning: seat already taken.");
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            // Append the new ticket in CSV format
            writer.write(ticket.toCSV()); // Assuming you have a toCSV method in your Ticket class
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTickets(List<Ticket> ticketList) throws DuplicateNameException {
        /**
         * save some tickets
         */
        for (Ticket ticket: ticketList) {
            saveTicket(ticket);
        }
    }
}
