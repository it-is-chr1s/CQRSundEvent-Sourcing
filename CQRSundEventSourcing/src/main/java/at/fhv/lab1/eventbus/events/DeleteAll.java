package at.fhv.lab1.eventbus.events;

public class DeleteAll extends Event{

    private static int counter;

    public DeleteAll(){
        super(counter++);
        eventType = EventType.DELETE_ALL_EVENT;
    }

    @Override
    public String toString() {
        return "DeleteAll{" +
                '}';
    }
}
