package at.fhv.lab1.eventbus.events;

public class BookRoomEvent extends Event{
    private long duration;
    private int roomNumber;
    private String customer;
    private static int counter = 0;

    public BookRoomEvent(){
        super(counter++);
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "BookRoomEvent{" +
                "duration=" + duration +
                ", roomNumber=" + roomNumber +
                ", customer='" + customer + '\'' +
                ", timestamp=" + getTimestamp() +
                ", id=" + getEventID() +
                '}';
    }
}
