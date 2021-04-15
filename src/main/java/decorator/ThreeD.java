package decorator;

public class ThreeD extends ExtraCost {
    public ThreeD(Ticket ticket) {
        super(ticket);
        super.setDescription("+ 3D movie");
    }
    @Override
    protected double cost() {
        return super.cost() + 3.50;
    }

    public String getDescription() {
        return super.ticket.getDescription() + super.getDescription();
    }
}