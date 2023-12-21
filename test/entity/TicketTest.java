package entity;

import org.junit.Test;

import java.time.LocalDateTime;

public class TicketTest {
    @Test
    public void testBaseCase() {
        LocalDateTime localDateTime = LocalDateTime.of(2023, 12, 20, 5, 20);
        Ticket testingTicket = new Ticket("Robin Mao", "robin.mao@mail.utoronto.ca", localDateTime);
        System.out.println(testingTicket.getTicketID());
    }
}
