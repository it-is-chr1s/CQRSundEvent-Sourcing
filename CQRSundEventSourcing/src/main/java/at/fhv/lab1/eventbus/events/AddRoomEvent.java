package at.fhv.lab1.eventbus.events;

public class AddRoomEvent extends Event{

    private static int counter = 0;

    private int number;
    private int numberOfBeds;
    private boolean bath;

    public AddRoomEvent(){
        super(counter++);
        eventType = EventType.ADD_ROOM_EVENT;
    }

    public AddRoomEvent(int number, int numberOfBeds, boolean bath) {
        this();
        this.number = number;
        this.numberOfBeds = numberOfBeds;
        this.bath = bath;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean getBath() {
        return bath;
    }

    public void setBath(boolean bath) {
        this.bath = bath;
    }

    @Override
    public String toString() {
        return "AddRoom{" +
                "number=" + number +
                ", numberOfBeds=" + numberOfBeds +
                ", bath=" + bath +
                '}';
    }
}
