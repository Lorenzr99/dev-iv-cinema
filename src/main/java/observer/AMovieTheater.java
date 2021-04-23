package observer;

import decorator.Marathon;
import decorator.StandardTicket;
import decorator.Ticket;

public class AMovieTheater implements MovieTheater {
    private String updateString;
    private int ticketsSold;
    private int seatsFilled;
    private int maxSeats;

    public AMovieTheater() {
        ticketsSold = 0;
        seatsFilled = 0;
        maxSeats = 5;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public int getSeatsFilled() {
        return seatsFilled;
    }

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

    //methods will call observers
    @Override
    public void ticketSold() {
        if(ticketsSold < maxSeats) {
            ticketsSold++;
            warnObservers("Ticket sold");
        } else {
            warnObservers("Sold out");
            System.out.println("** Movie theater is SOLD OUT!");
        }
    }

    @Override
    public void seatFilled() {
            if (seatsFilled <= ticketsSold && ticketsSold != 0) {
                seatsFilled++;
                warnObservers("Seat filled");
            } else {
                warnObservers("No ticket");
                System.out.println("** A ticket must be bought first!");
            }
    }
}
