package state;

public class MovieTheater {
    public class MovieTheater {
        public final State NO_QUARTER;
        public final State HAS_QUARTER;
        public final State SOLD;
        public final State SOLD_OUT;
        public final State WINNER;
        private State state;
        private int numberOfSeats;

        public int getNumberOfSeats() {
            return numberOfSeats;
        }

        public MovieTheater(int numberOfSeats) {
            NO_QUARTER = new NoQuarterSate(this);
            HAS_QUARTER = new HasQuarterState(this);
            SOLD = new SoldState(this);
            SOLD_OUT = new SoldOutState(this);
            WINNER = new WinnerState(this);
            state = SOLD_OUT;
            refill(numberOfSeats);
        }

        public void refill(int numberOfGumballs) {
            if (this.numberOfSeats == 0 && numberOfGumballs > 0) {
                this.numberOfSeats = numberOfGumballs;
                state = NO_QUARTER;
            }
        }

        void setState(State state) {
            this.state = state;
        }

        public boolean isEmpty() {
            return numberOfSeats == 0;
        }

        void releaseBall() {
            if (!isEmpty()) {
                System.err.println("Gumball coming your way");
                numberOfSeats--;
            }
        }

        public void insertQuarter() {
            state.insertQuarter();
        }

        public void ejectQuarter() {
            state.ejectQuarter();
        }

        public void turnCrank() {
            state.turnCrank();
            state.dispense();
        }
    }

}
