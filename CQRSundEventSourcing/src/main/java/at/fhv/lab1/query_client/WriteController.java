package at.fhv.lab1.query_client;

import at.fhv.lab1.eventbus.events.EventType;
import at.fhv.lab1.eventbus.publish_subcribe.Subscriber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;

@Component
@RestController
public abstract class WriteController implements CommandLineRunner {

    private final WebClient localApiClient = WebClient.create("http://localhost:8080");

    protected void subscribe(EventType eventType, String client, Thread thread) throws InterruptedException{
        Subscriber subscriber = new Subscriber(eventType, client);
        ClientResponse response = null;

        do {
            try {
                response = localApiClient
                        .post()
                        .uri("/subscribe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(subscriber), Subscriber.class)
                        .exchange()
                        .block();

                if (response != null) {
                    if (response.statusCode() == HttpStatus.OK) {
                        System.out.println("Subscribed successfully on " + eventType);
                        continue;
                    } else {
                        System.out.println("Failed to subscribe on" + eventType + ". HTTP status code: " + response.statusCode() + "\nRetrying to subcribe in 5 seconds.");
                    }
                } else {
                    System.out.println("Failed to subscribe on" + eventType + ". No response received.\nRetrying to subcribe in 5 seconds.");
                }
            }catch(WebClientRequestException e){
                System.out.println("Error connecting to server: " + e.getMessage() + ". Retrying in 5 seconds.");
            }

            thread.sleep(5000);
        }while (response == null || response.statusCode() != HttpStatus.OK);
    }
}
