package at.fhv.lab1.eventbus.events;

public interface Event {
    public long getTimestamp();
    public void setTimestamp(long timestamp);
}
