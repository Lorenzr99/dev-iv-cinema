package observer;

public class Seat {
    private MovieTheater movieTheater;

    public Seat(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
        movieTheater.seatFilled();
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        if (movieTheater.getSeatsFilled() == 1) return "1 seat is currently filled!";
        else return movieTheater.getSeatsFilled() + " seats are currently filled!";
    }
}
