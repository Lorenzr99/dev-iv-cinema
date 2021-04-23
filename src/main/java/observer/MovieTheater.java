package observer;

import java.util.HashSet;
import java.util.Set;

public interface MovieTheater {
    Set<Observer> observers = new HashSet<>();

    void addObserver(Observer observer);
    String warnObservers(String message);

    int getTicketsSold();
    void ticketSold();

    int getSeatsFilled();
    void seatFilled();
}
