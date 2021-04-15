package decorator;

public class Food extends ExtraCost {
    public Food(Ticket ticket) {
        super(ticket);
        super.setDescription("+ food");
    }
    @Override
    protected double cost() {
        return super.cost() + 2.50;
    }

    public String getDescription() {
        return super.ticket.getDescription() + super.getDescription();
    }
}