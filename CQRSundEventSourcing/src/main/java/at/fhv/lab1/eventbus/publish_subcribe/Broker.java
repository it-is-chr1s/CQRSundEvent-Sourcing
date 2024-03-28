package at.fhv.lab1.eventbus.publish_subcribe;

import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.EventType;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Broker {
    private static Broker instance = null;
    private Map<EventType, ArrayList<String>> subscribers = new HashMap<>();

    public static Broker initialise(){
        if(instance == null) {
            instance = new Broker();
        }

        return instance;
    }

    private Broker(){
        for(EventType type : EventType.values()){
            subscribers.put(type, new ArrayList<>());
        }
    }

    public void subscribe(Subscriber subscriber){
        if(!subscribers.get(subscriber.getType()).contains(subscriber.getClient()))
            subscribers.get(subscriber.getType()).add(subscriber.getClient());
    }

    public void publish(Event event){
        WebClient localApiClient;

        for(String subscriber : subscribers.get(event.getEventType())){
            localApiClient = WebClient.create(subscriber);
            System.out.println(subscriber + "/" + event.getEventType());

            localApiClient
                    .post()
                    .uri("/" + event.getEventType())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(Mono.just(event),Event.class)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();;
        }
    }
}
