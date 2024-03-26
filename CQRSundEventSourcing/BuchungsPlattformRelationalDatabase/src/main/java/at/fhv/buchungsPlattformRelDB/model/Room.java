package at.fhv.buchungsPlattformRelDB.model;

import jakarta.persistence.*;

@Entity(name = "room")
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "number")
    private int number;
    @Column(name = "numberOfBeds")
    private int numberOfBeds;
    @Column(name = "bath")
    private boolean bath;

    public Room(){

    }

    public Room(int number, int numberOfBeds, boolean bath) {
        this.number = number;
        this.numberOfBeds = numberOfBeds;
        this.bath = bath;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isBath() {
        return bath;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", numberOfBeds=" + numberOfBeds +
                ", bath=" + bath +
                '}';
    }
}
