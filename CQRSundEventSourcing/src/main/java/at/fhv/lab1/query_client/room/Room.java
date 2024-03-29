package at.fhv.lab1.query_client.room;

public class Room {
    private int number;
    private int numberOfBeds;
    private boolean bath;

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
