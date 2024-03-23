package at.fhv.lab1.eventbus.events;

public class CancelBookingEvent implements Event{
    private int reservationNumber;
    private long timestamp;

    public CancelBookingEvent(){
        this.timestamp = System.currentTimeMillis();
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    @Override
    public long getTimestamp(){
        return timestamp;
    }

    @Override
    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CancelBookingCommand{" +
                "reservationNumber=" + reservationNumber +
                '}';
    }
}
