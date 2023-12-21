package entity;

import java.time.LocalDateTime;
import java.util.Random;

public class Ticket {
    /**
     * @Param: buyerName: name of the ticket owner.
     * @Param: purchaseDate: date of purchase.
     * @Param: ticketID: a randomized ticket.
     */
    private String buyerName; // Chenxu Mao
    private String email; // Robin.mao@mail.utoronto.ca
    private LocalDateTime purchaseDate; // 2023.12.20
    private String ticketID; // #TODO: ticketID

    private Random random = new Random();

    public Ticket(String buyerName, String email, LocalDateTime purchaseDate) {
        this.buyerName = buyerName;
        this.email = email;
        this.purchaseDate = purchaseDate;
        // TODO: confirm the ticketID
        this.ticketID = "CSSA24-" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) +
                random.nextInt(9) + (char) (random.nextInt(26) + 'A') +
                random.nextInt(9) + (char) (random.nextInt(26) + 'A') + (char) (random.nextInt(26) + 'A') +
                random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
    }

    public String getBuyerName() {
        return this.buyerName;
    }

    public LocalDateTime getPurchaseDate() {
        return this.purchaseDate;
    }

    public String getTicketID() {
        return this.ticketID;
    }

    public String getEmail() {
        return this.email;
    }
}