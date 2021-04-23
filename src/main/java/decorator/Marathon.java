package decorator;

public class Marathon extends ExtraCost {
    public Marathon(Ticket ticket) {
        super(ticket);
        super.setDescription(" + marathon movie");
    }
    @Override
    protected double cost() {
        return super.cost() + 2.25;
    }

    public String getDescription() {
        return super.ticket.getDescription() + super.getDescription();
    }
}