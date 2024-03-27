package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.*;
import at.fhv.lab1.eventbus.subscriber.Broker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {

    private final List<Event> bookRoomEvents = new ArrayList<>();
    private final List<Event> cancelBookingEvents = new ArrayList<>();
    private final List<Event> createCustomerEvents = new ArrayList<>();
    private final List<Event> addRoomEvents = new ArrayList<>();
    private final Broker broker = Broker.initialise();

    public void processEvent(Event event) {
        if(event instanceof BookRoomEvent){
            bookRoomEvents.add(event);
        }else if(event instanceof CancelBookingEvent){
            cancelBookingEvents.add(event);
        }else if(event instanceof CreateCustomerEvent){
            createCustomerEvents.add(event);
        }else if(event instanceof AddRoomEvent){
            addRoomEvents.add(event);
        }

        broker.publish(event);
        System.out.println("Event has been published.");
    }
}
