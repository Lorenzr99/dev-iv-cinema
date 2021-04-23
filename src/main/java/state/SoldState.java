package state;

import state.MovieTheater;
import state.State;

public class SoldState extends State {
    public SoldState(MovieTheater movietheater) {
        super(movietheater);
    }

    @Override
    protected void dispense() {
        getMovieTheater().states();
        if (!getMovieTheater().isEmpty())
            setState(getMovieTheater().NO_QUARTER);
        else
            setState(getMovieTheater().SOLD_OUT);
    }


}