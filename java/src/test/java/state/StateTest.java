package state;


import decorator.StandardTicket;
import observer.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {
    @Test
    void initializeState() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer firstObserver = new AnObserver(movieTheater,1);
        movieTheater.addObserver(firstObserver);
        assertEquals("state.TicketsAvailable", movieTheater.getState());
    }

    @Test
    void seatAvailable() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer secondObserver = new AnObserver(movieTheater,2);
        movieTheater.addObserver(secondObserver);
        new StandardTicket(movieTheater);
        assertEquals("state.SeatsAvailable", movieTheater.getState());
    }

    @Test
    void ticketsAvailable() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer thirdObserver = new AnObserver(movieTheater,3);
        movieTheater.addObserver(thirdObserver);
        new StandardTicket(movieTheater);
        new Seat(movieTheater);
        assertEquals("state.TicketsAvailable", movieTheater.getState());
    }

    @Test
    void ticketsSoldOut() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer fourthObserver = new AnObserver(movieTheater,4);
        movieTheater.addObserver(fourthObserver);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        assertEquals("state.SoldOut", movieTheater.getState());
    }

    @Test
    void seatsFull() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer fifthObserver = new AnObserver(movieTheater,5);
        movieTheater.addObserver(fifthObserver);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new Seat(movieTheater);
        new Seat(movieTheater);
        new Seat(movieTheater);
        new Seat(movieTheater);
        new Seat(movieTheater);
        assertEquals("state.Full", movieTheater.getState());
    }
}
