package entity;

import java.time.LocalDate;
import java.util.Random;

public class Ticket {
    /**
     * @Param: buyerName: name of the ticket owner.
     * @Param: purchaseDate: date of purchase.
     * @Param: ticketID: a randomized ticket.
     */
    private String buyerName; // Chenxu Mao
    private String email; // Robin.mao@mail.utoronto.ca
    private LocalDate purchaseDate; // 2023.12.20
    private String seat; // A1
    private String cell; // xxx-xxx-xxxx
    private String ticketID; //
    private Random random = new Random();

    public Ticket(String buyerName, String email, String seat, String cell, LocalDate purchaseDate) {
        this.buyerName = buyerName;
        this.email = email;
        this.purchaseDate = purchaseDate;
        this.seat = seat;
        this.cell = cell;
        // TODO: confirm the ticketID algorithm
        this.ticketID = "CSSA24-" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) +
                random.nextInt(9) + (char) (random.nextInt(26) + 'A') +
                random.nextInt(9) + (char) (random.nextInt(26) + 'A') + (char) (random.nextInt(26) + 'A') +
                random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
    }

    public String getBuyerName() {
        return this.buyerName;
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public String getTicketID() {
        return this.ticketID;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSeat() {
        return this.seat;
    }

    public String getCell() {
        return this.cell;
    }
}