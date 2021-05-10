package state;

import observer.MovieTheater;

public class TicketsAvailable extends State {
    public TicketsAvailable(MovieTheater movieTheater) { super(movieTheater); }

    @Override
    public void seatFilled() {
        getMovieTheater().warnObservers("No ticket");
        System.out.println("** A ticket must be bought first!");
    }

    @Override
    public String toString() { return "state.TicketsAvailable"; }
}
