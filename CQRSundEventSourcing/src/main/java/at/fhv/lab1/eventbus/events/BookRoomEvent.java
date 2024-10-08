package at.fhv.lab1.eventbus.events;

import java.util.concurrent.atomic.AtomicInteger;

public class BookRoomEvent extends Event{
    private long startDate;
    private long endDate;
    private int roomNumber;
    private String customer;

    private final int reservationNumber;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public BookRoomEvent(){
        super(counter.get());
        reservationNumber = counter.getAndIncrement();
        eventType = EventType.BOOK_ROOM_EVENT;
    }

    public BookRoomEvent(long startDate, long endDate, int roomNumber, String customer) {
        this();
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.customer = customer;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
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

    public int getReservationNumber() {
        return reservationNumber;
    }
    @Override
    public String toString() {
        return "BookRoomEvent{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", roomNumber=" + roomNumber +
                ", customer='" + customer + '\'' +
                ", timestamp=" + getTimestamp() +
                ", id=" + getEventID() +
                ", reservationNumber=" + reservationNumber +
                '}';
    }
}
