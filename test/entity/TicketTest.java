package entity;

import org.junit.Test;

import java.time.LocalDate;

public class TicketTest {
    @Test
    public void testBaseCase() {
        LocalDate localDate = LocalDate.of(2023, 12, 20);
        Ticket testingTicket = new Ticket("Robin Mao", "robin.mao@mail.utoronto.ca", "A1", "647-268-9505", localDate);
        System.out.println(testingTicket.getTicketID());
    }
}
