package at.fhv.lab1.eventbus.events;

public class BookRoomEvent implements Event{
    private long duration;
    private int roomNumber;
    private String customer;
    private long timestamp;

    public BookRoomEvent(){
        timestamp = System.currentTimeMillis();
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
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "BookRoomCommand{" +
                "duration=" + duration +
                ", roomNumber=" + roomNumber +
                ", customer='" + customer + '\'' +
                '}';
    }
}
