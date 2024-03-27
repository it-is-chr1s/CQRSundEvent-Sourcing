package at.fhv.lab1.commandclient;

import at.fhv.lab1.eventbus.events.Event;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class EventPublisher {

    private static EventPublisher instance;

    private final WebClient localApiClient = WebClient.create("http://localhost:8080");

    public static EventPublisher initialize(){
        if(instance == null)
            instance = new EventPublisher();

        return instance;
    }

    private EventPublisher() {
    }

    public Boolean publishEvent(Event event) {
        return localApiClient
                .post()
                .uri("/event")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
