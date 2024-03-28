package at.fhv.lab1.eventbus.events;

import java.util.concurrent.atomic.AtomicInteger;

public class AddRoomEvent extends Event{

    private static final AtomicInteger counter = new AtomicInteger(0);

    private int number;
    private int numberOfBeds;
    private boolean bath;

    public AddRoomEvent(){
        super(counter.getAndIncrement());
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
                " id=" + getEventID() +
                '}';
    }
}
