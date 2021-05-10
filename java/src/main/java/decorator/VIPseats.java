package decorator;

public class VIPseats extends ExtraCost {
    public VIPseats(Ticket ticket) {
        super(ticket);
        super.setDescription(" + VIP seats");
    }
    @Override
    protected double cost() {
        return super.cost() + 7.00;
    }

    public String getDescription() {
        return super.ticket.getDescription() + super.getDescription();
    }
}