package state;

public class SoldOutState extends State {
    public SoldOutState(MovieTheater gumballMachine) {
        super(gumballMachine);
    }

    @Override
    protected void insertQuarter() {
        System.err.println("Returning quarter");
        getGumballMachine().ejectQuarter();
    }
}