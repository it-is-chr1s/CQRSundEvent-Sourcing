package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.*;
import at.fhv.lab1.eventbus.publish_subcribe.Broker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {
    private final List<Event> events = new ArrayList<>();
    private final Broker broker = Broker.initialise();

    public void processEvent(Event event) {
        events.add(event);

        broker.publish(event);
        System.out.println("Event has been published.");
    }

    public void reloadQueryModels(){
        for(Event event : events){
            broker.publish(event);
        }
    }

    public List<Event> getEvents() {
        return events;
    }
}
