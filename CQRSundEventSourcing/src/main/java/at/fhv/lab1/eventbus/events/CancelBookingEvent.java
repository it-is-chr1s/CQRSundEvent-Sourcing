package at.fhv.lab1.commandclient.commands;

public class CancelBookingCommand extends Command{
    private int reservationNumber;

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    boolean validate(){
        return true;
    }

    @Override
    public String toString() {
        return "CancelBookingCommand{" +
                "reservationNumber=" + reservationNumber +
                '}';
    }
}
