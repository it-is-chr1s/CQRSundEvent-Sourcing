package at.fhv.lab1.eventbus.events;

public class CancelBookingEvent extends Event{
    private int reservationNumber;
    private static int counter = 0;

    public CancelBookingEvent(){
        super(counter++);
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    @Override
    public String toString() {
        return "CancelBookingEvent{" +
                "reservationNumber=" + reservationNumber +
                ", timestamp=" + getTimestamp() +
                ", id=" + getEventID() +
                '}';
    }
}
