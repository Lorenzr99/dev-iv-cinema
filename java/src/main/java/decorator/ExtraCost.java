package decorator;

public abstract class ExtraCost extends Ticket {
    protected Ticket ticket;
    protected ExtraCost(Ticket ticket) {
        this.ticket = ticket;
    }

    protected double cost() {
        return ticket.cost();
    }
}
