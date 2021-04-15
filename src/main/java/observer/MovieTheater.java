package observer;

import java.util.HashSet;
import java.util.Set;

public interface MovieTheater {
    Set<Observer> observers = new HashSet<>();

    void addObserver(Observer observer);
    String warnObservers();

    int getTicketCount();
    String ticketSold();

    String seatFilled();
}
