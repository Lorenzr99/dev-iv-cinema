package decorator;

public abstract class Ticket {
        protected String description;

        protected void setDescription(String description) {
            this.description = description;
        }

        protected String getDescription() {
            return description;
        }

        protected abstract double cost();

}
