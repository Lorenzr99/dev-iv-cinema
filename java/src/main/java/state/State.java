package state;

import observer.MovieTheater;

public abstract class State {
    private MovieTheater movieTheater;
    public State(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
    }

    protected MovieTheater getMovieTheater() {
        return movieTheater;
    }

    public void ticketSold() {
        getMovieTheater().increaseTicketCount();
        getMovieTheater().warnObservers("Ticket sold");
    }

    public void seatFilled() {
        getMovieTheater().increaseSeatCount();
        getMovieTheater().warnObservers("Seat filled");
    }

    @Override
    public String toString() {
        return "State{" +
                "movieTheater=" + movieTheater +
                '}';
    }
}

