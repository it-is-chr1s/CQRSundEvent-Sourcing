package at.fhv.lab1.eventbus.rest;

import at.fhv.lab1.eventbus.EventRepository;
import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.publish_subcribe.Broker;
import at.fhv.lab1.eventbus.publish_subcribe.Subscriber;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventRestController {

    private final EventRepository repository;
    private final Broker broker;

    public EventRestController(EventRepository repository) {
        this.repository = repository;
        this.broker = Broker.initialise();
    }

    @PostMapping(value = "/event", consumes = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/subscribe", consumes = "application/json")
    public void subscribe(@RequestBody Subscriber subscriber){
        broker.subscribe(subscriber);
    }
}
