package observer;

import state.*;

public class AnObserver implements Observer {
    private int observerCount;
    private MovieTheater movieTheater;
    public final State TICKETS_AVAILABLE;
    public final State SEATS_AVAILABLE;
    public final State SOLD_OUT;
    public final State FULL;

    public AnObserver(MovieTheater movieTheater, int observerCount) {
        this.movieTheater = movieTheater;
        this.observerCount = observerCount;
        TICKETS_AVAILABLE = new TicketsAvailable(movieTheater);
        SEATS_AVAILABLE = new SeatsAvailable(movieTheater);
        SOLD_OUT = new SoldOut(movieTheater);
        FULL = new Full(movieTheater);
        movieTheater.setState(TICKETS_AVAILABLE);
    }

    @Override
    public String update(String message) {
        updateState();
        System.out.println("\n-- Observer " + observerCount + " was updated: " + message + " --");
        return "AnObserver was updated!";
    }

    @Override
    public void updateState() {
        if(movieTheater.getTicketsSold() > movieTheater.getSeatsFilled()) movieTheater.setState(SEATS_AVAILABLE);
        else movieTheater.setState(TICKETS_AVAILABLE);
        if(movieTheater.getTicketsSold() >= movieTheater.getMaxSeats()) movieTheater.setState(SOLD_OUT);
        if(movieTheater.getSeatsFilled() >= movieTheater.getMaxSeats()) movieTheater.setState(FULL);
    }
}
