package observer;


import decorator.StandardTicket;
import decorator.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.rmi.MarshalledObject;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObserverTest {
    @Test
    void warnObservers() {
        Observer firstObserver = new AnObserver(1);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(firstObserver);
        assertEquals("AnObserver was updated!", movieTheater.warnObservers("Test"));
    }

    @Test
    void ticketSold() {
        Observer secondObserver = new AnObserver(2);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(secondObserver);
        new StandardTicket(movieTheater);
        assertEquals(1, movieTheater.getTicketsSold());
    }

    @Test
    void multipleTicketsSold() {
        Observer thirdObserver = new AnObserver(3);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(thirdObserver);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        assertEquals(3, movieTheater.getTicketsSold());
    }

    @Test
    void ticketsSoldOut() {
        Observer fourthObserver = new AnObserver(4);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(fourthObserver);
        new StandardTicket(movieTheater); //1
        new StandardTicket(movieTheater); //2
        new StandardTicket(movieTheater); //3
        new StandardTicket(movieTheater); //4
        new StandardTicket(movieTheater); //5 ! Maximum tickets
        new StandardTicket(movieTheater); //6 ! Tickets sold out
        assertEquals(5, movieTheater.getTicketsSold());
    }

    @Test
    void seatFilled() {
        Observer fifthObserver = new AnObserver(5);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(fifthObserver);
        new StandardTicket(movieTheater);
        new Seat(movieTheater);
        assertEquals(1, movieTheater.getSeatsFilled());
    }

    @Test
    void seatFilledWithoutTicket() {
        Observer sixthObserver = new AnObserver(6);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(sixthObserver);
        new Seat(movieTheater);
        assertEquals(0, movieTheater.getSeatsFilled());
    }
}
