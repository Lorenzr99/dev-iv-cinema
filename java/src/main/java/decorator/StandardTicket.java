package decorator;

import observer.MovieTheater;

public class StandardTicket extends Ticket {
    private MovieTheater movieTheater;

    public StandardTicket(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
        movieTheater.ticketSold();
        System.out.println(this.toString());
        setDescription("Ticket sold! This is the price of a standard ticket");
    }

    @Override
    protected double cost() {
        return 9.50;
    }

    @Override
    public String toString() {
        if(movieTheater.getTicketsSold() == 1) return "1 ticket is currently sold!";
        else return movieTheater.getTicketsSold() + " tickets are currently sold!";
    }
}
