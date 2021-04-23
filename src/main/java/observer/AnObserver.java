package observer;

public class AnObserver implements Observer {
    private int observerCount;

    public AnObserver(int observerCount) {
        this.observerCount = observerCount;
    }

    @Override
    public String update(String message) {
        System.out.println("\n-- Observer " + observerCount + " was updated: " + message + " --");
        return "AnObserver was updated!";
    }
}
