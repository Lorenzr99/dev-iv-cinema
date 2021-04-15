package decorator;

public class StandardTicket extends Ticket {
    public StandardTicket() {
        setDescription("This is the price of a standard ticket");
    }

    @Override
    protected double cost() {
        return 9.50;
    }
}
