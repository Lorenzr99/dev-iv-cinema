package decorator;

import junit.framework.TestCase;
import org.junit.Test;

public class TicketTest extends TestCase {
    @Test
    void createTicket() {
        Ticket ticket = new StandardTicket();
        ticket = new Drinks(ticket);
        ticket = new Food(ticket);
        ticket = new Marathon(ticket);
        ticket = new ThreeD(ticket);
        ticket = new VIPseats(ticket);
        System.out.println(ticket.getDescription() + " €" + ticket.cost());
    }
}



