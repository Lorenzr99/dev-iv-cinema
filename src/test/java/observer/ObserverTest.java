package observer;


import decorator.StandardTicket;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ObserverTest {
    @Test
    void warnObservers() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer firstObserver = new AnObserver(movieTheater,1);
        movieTheater.addObserver(firstObserver);
        assertEquals("AnObserver was updated!", movieTheater.warnObservers("Test"));
    }

    @Test
    void ticketSold() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer secondObserver = new AnObserver(movieTheater,2);
        movieTheater.addObserver(secondObserver);
        new StandardTicket(movieTheater);
        assertEquals(1, movieTheater.getTicketsSold());
    }

    @Test
    void multipleTicketsSold() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer thirdObserver = new AnObserver(movieTheater,3);
        movieTheater.addObserver(thirdObserver);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        assertEquals(3, movieTheater.getTicketsSold());
    }

    @Test
    void ticketsSoldOut() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer fourthObserver = new AnObserver(movieTheater,4);
        movieTheater.addObserver(fourthObserver);
        new StandardTicket(movieTheater); //1
        new StandardTicket(movieTheater); //2
        new StandardTicket(movieTheater); //3
        new StandardTicket(movieTheater); //4
        new StandardTicket(movieTheater); //5 ! Maximum tickets
        new StandardTicket(movieTheater); //6 ! Tickets already sold out
        assertEquals(5, movieTheater.getTicketsSold());
    }

    @Test
    void seatFilled() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer fifthObserver = new AnObserver(movieTheater,5);
        movieTheater.addObserver(fifthObserver);
        new StandardTicket(movieTheater);
        new Seat(movieTheater);
        assertEquals(1, movieTheater.getSeatsFilled());
    }

    @Test
    void seatFilledWithoutTicket() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer sixthObserver = new AnObserver(movieTheater,6);
        movieTheater.addObserver(sixthObserver);
        new Seat(movieTheater);
        assertEquals(0, movieTheater.getSeatsFilled());
    }

    @Test
    void allSeatsFilled() {
        MovieTheater movieTheater = new AMovieTheater();
        Observer seventhObserver = new AnObserver(movieTheater,7);
        movieTheater.addObserver(seventhObserver);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new StandardTicket(movieTheater);
        new Seat(movieTheater); //1
        new Seat(movieTheater); //2
        new Seat(movieTheater); //3
        new Seat(movieTheater); //4
        new Seat(movieTheater); //5 ! Maximum seats
        new Seat(movieTheater); //6 ! Seats already full
        assertEquals(5, movieTheater.getSeatsFilled());
    }
}
