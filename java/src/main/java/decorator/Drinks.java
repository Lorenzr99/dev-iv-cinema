package decorator;

public class Drinks extends ExtraCost {
    public Drinks(Ticket ticket) {
        super(ticket);
        super.setDescription(" + drinks");
    }
    @Override
    protected double cost() {
        return super.cost() + 1.25;
    }

    public String getDescription() {
        return super.ticket.getDescription() + super.getDescription();
    }
}


