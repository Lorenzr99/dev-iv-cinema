package observer;

import decorator.Marathon;
import decorator.StandardTicket;
import decorator.Ticket;
import state.SeatsAvailable;
import state.SoldOut;
import state.State;
import state.TicketsAvailable;

public class AMovieTheater implements MovieTheater {
    private String updateString;
    private int ticketsSold;
    private int seatsFilled;
    private int maxSeats;
    private State state;

    public AMovieTheater() {
        ticketsSold = 0;
        seatsFilled = 0;
        maxSeats = 5;
    }

    public void setState(State state) {
        this.state = state;
    }
    public String getState() { return state.toString(); }

    public int getTicketsSold() { return ticketsSold; }
    public void increaseTicketCount() { ticketsSold++; }

    public int getSeatsFilled() {
        return seatsFilled;
    }
    public int getMaxSeats() { return maxSeats; }
    public void increaseSeatCount() { seatsFilled++; }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public String warnObservers(String message) {
        for (Observer observer: observers) {
            updateString = observer.update(message);
        }
        return updateString;
    }

    @Override
    public void ticketSold() {
        state.ticketSold();
    }

    @Override
    public void seatFilled() {
        state.seatFilled();
    }
}
