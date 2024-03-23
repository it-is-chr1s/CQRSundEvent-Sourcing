package at.fhv.lab1.commandclient.commands;

public class BookRoomCommand extends Command{
    private long duration;
    private int roomNumber;
    private String customer;

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

    boolean validate(){
        return true;
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
