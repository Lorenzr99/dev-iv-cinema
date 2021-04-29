package state;

import observer.MovieTheater;

public class Full extends State {
    public Full(MovieTheater movieTheater) { super(movieTheater); }

    @Override
    public void ticketSold() {
        getMovieTheater().warnObservers("Sold out");
        System.out.println("** Movie theater is SOLD OUT!");
    }

    @Override
    public void seatFilled() {
        getMovieTheater().warnObservers("All seats filled");
        System.out.println("** All seats are filled!");
    }

    @Override
    public String toString() { return "state.Full"; }
}
