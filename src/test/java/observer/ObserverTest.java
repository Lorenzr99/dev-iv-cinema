package observer;


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
        assertEquals(movieTheater.warnObservers(), "AnObserver was updated!");
    }

    @Test
    void ticketSold() {
        Observer secondObserver = new AnObserver(2);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(secondObserver);
        assertEquals(movieTheater.ticketSold(), "AnObserver was updated!");
    }

    @Test
    void multipleTicketsSold() {
        Observer thirdObserver = new AnObserver(3);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(thirdObserver);
        movieTheater.ticketSold();
        movieTheater.ticketSold();
        movieTheater.ticketSold();
        assertEquals(movieTheater.getTicketCount(), 3);
    }

    @Test
    void seatFilled() {
        Observer fourthObserver = new AnObserver(4);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(fourthObserver);
        movieTheater.ticketSold();
        assertEquals(movieTheater.seatFilled(), "AnObserver was updated!");
    }

    @Test
    void seatFilledWithoutTicket() {
        Observer fifthObserver = new AnObserver(5);
        MovieTheater movieTheater = new AMovieTheater();
        movieTheater.addObserver(fifthObserver);
        assertEquals(movieTheater.seatFilled(), "A ticket must be bought first!");
        }
}
