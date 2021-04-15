package observer;

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

    public int getTicketCount() {
        return ticketsSold;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public String warnObservers() {
        for (Observer observer: observers) {
            updateString = observer.update();
        }
        return updateString;
    }

    //methods will call observers
    @Override
    public String ticketSold() {
        if(ticketsSold < maxSeats) {
            ticketsSold++;
            if(ticketsSold == 1) System.out.println("1 ticket is currently sold!");
            else System.out.println(ticketsSold + " tickets are currently sold!");
            return warnObservers();
        } else {
            System.out.println("Movie theater is SOLD OUT!");
            return warnObservers();
        }
    }

    @Override
    public String seatFilled() {
        if(seatsFilled <= ticketsSold && ticketsSold != 0) {
            seatsFilled++;
            if(seatsFilled == 1) System.out.println("1 seat is currently filled!");
            else System.out.println(seatsFilled + " seats are currently filled!");
            return warnObservers();
        } else {
            return "A ticket must be bought first!";
        }
    }
}
