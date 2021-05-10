package state;

import observer.MovieTheater;

public class SeatsAvailable extends State {
    public SeatsAvailable(MovieTheater movieTheater) { super(movieTheater); }

    @Override
    public String toString() { return "state.SeatsAvailable"; }
}
