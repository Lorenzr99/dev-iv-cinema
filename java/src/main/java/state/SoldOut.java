package state;

import observer.MovieTheater;

public class SoldOut extends State{
    public SoldOut(MovieTheater movieTheater) { super(movieTheater); }

    @Override
    public void ticketSold() {
        getMovieTheater().warnObservers("Sold out");
        System.out.println("** Movie theater is SOLD OUT!");
    }

    @Override
    public String toString() { return "state.SoldOut"; }
}
