package at.fhv.buchungsPlattformRelDB.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "booking")
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "reservation_number")
    private int reservationNumber;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_number", nullable = false)
    @JsonIgnore
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "username", nullable = false)
    @JsonIgnore
    private Customer customer;

    public Booking(){

    }

    public Booking(int reservationNumber, String startDate, String endDate, Room room, Customer customer) {
        this.reservationNumber = reservationNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.customer = customer;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "reservationNumber=" + reservationNumber +
                ", roomNumber=" + room.getNumber() +
                ", username='" + customer.getUsername() + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
