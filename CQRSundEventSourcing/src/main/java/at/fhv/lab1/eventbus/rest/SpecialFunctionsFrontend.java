package at.fhv.lab1.eventbus.rest;

import at.fhv.lab1.eventbus.EventRepository;
import at.fhv.lab1.eventbus.events.Event;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class SpecialFunctionsFrontend {

    private final EventRepository repository;

    public SpecialFunctionsFrontend(EventRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/getEvents")
    public List<Event> getEvents(){
        return repository.getEvents();
    }

    @PostMapping(value = "/reloadQueryModels")
    public void reloadQueryModels(){
        repository.reloadQueryModels();
    }
}
