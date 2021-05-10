package decorator;

public abstract class Ticket {
        protected String description;

        protected void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        protected abstract double cost();

        public double getCost() { return cost(); };

}
