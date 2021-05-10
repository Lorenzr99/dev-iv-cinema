package observer;

import state.State;

import java.util.HashSet;
import java.util.Set;

public interface MovieTheater {
    Set<Observer> observers = new HashSet<>();

    void addObserver(Observer observer);
    String warnObservers(String message);

    void setState(State state);
    String getState();

    int getTicketsSold();
    void increaseTicketCount();
    void ticketSold();

    int getSeatsFilled();
    int getMaxSeats();
    void increaseSeatCount();
    void seatFilled();
}
