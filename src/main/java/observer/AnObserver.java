package observer;

public class AnObserver implements Observer {
    private int observerCount;

    public AnObserver(int observerCount) {
        this.observerCount = observerCount;
    }

    @Override
    public String update() {
        System.out.println("Observer " + observerCount + " was updated!");
        return "AnObserver was updated!";
    }
}
