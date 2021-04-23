package state;

import observer.AMovieTheater;

public abstract class State {
    private MovieTheater movietheater;
    public State(MovieTheater gumballMachine) {
        this.movietheater = gumballMachine;
    }

    protected MovieTheater getGumballMachine() {
        return movietheater;
    }
}

