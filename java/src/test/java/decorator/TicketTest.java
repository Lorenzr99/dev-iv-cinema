package decorator;

import observer.AMovieTheater;
import observer.MovieTheater;
import org.junit.jupiter.api.Test;

public class TicketTest {
    @Test
    void createTicket() {
        MovieTheater movieTheater = new AMovieTheater();
        Ticket ticket = new StandardTicket(movieTheater);
        ticket = new Drinks(ticket);
        ticket = new Food(ticket);
        ticket = new Marathon(ticket);
        ticket = new ThreeD(ticket);
        ticket = new VIPseats(ticket);
        System.out.println(ticket.getDescription() + " €" + ticket.getCost());
    }
}



