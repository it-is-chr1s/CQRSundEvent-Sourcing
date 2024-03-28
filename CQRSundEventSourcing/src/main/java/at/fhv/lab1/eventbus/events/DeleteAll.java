package at.fhv.lab1.eventbus.events;

import java.util.concurrent.atomic.AtomicInteger;

public class DeleteAll extends Event{

    private static final AtomicInteger counter = new AtomicInteger(0);

    public DeleteAll(){
        super(counter.getAndIncrement());
        eventType = EventType.DELETE_ALL_EVENT;
    }

    @Override
    public String toString() {
        return "DeleteAll{" +
                '}';
    }
}
