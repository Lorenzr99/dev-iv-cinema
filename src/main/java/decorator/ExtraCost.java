package decorator;

public abstract class ExtraCost extends Ticket {
    protected Ticket ticket;
    protected ExtraCost(Ticket beverage) {
        this.ticket = beverage;
    }

    protected double cost() {
        return ticket.cost();
    }
}
