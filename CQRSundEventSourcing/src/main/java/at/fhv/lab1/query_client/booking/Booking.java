package at.fhv.lab1.query_client.booking;

public class Booking{
    private int reservationNumber;
    private int roomNumber;
    private long startDate;
    private long endDate;
    private String customer;

    public Booking(int reservationNumber, int roomNumber, long startDate, long endDate, String customer) {
        this.reservationNumber = reservationNumber;
        this.roomNumber = roomNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public String getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "reservationNumber=" + reservationNumber +
                ", roomNumber=" + roomNumber +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", customer='" + customer + '\'' +
                '}';
    }
}
