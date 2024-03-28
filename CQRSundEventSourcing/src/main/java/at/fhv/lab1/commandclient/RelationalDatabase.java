package at.fhv.lab1.commandclient;

import at.fhv.lab1.eventbus.events.AddRoomEvent;
import at.fhv.lab1.eventbus.events.BookRoomEvent;
import at.fhv.lab1.eventbus.events.CreateCustomerEvent;
import at.fhv.lab1.eventbus.events.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class RelationalDatabase {

    private static final WebClient localApiClient = WebClient.create("http://localhost:8082");

    private RelationalDatabase() {
    }

    public static boolean deleteBooking(int reservationNumber){
        return HttpStatus.OK == localApiClient
                .post()
                .uri("/deleteBooking?reservationNumber={reservationNumber}", reservationNumber)
                .exchange()
                .block()
                .statusCode();
    }

    public static boolean save(BookRoomEvent bookRoomEvent){
        Boolean exists = localApiClient
                .post()
                .uri("/existsByReservationNumber?reservationNumber={reservationNumber}", bookRoomEvent.getReservationNumber())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if(Boolean.FALSE.equals(exists)){
            localApiClient
                    .post()
                    .uri("/updateBooking?roomNumber={roomNumber}&username={username}", bookRoomEvent.getRoomNumber(), bookRoomEvent.getCustomer())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(bookRoomEvent),Event.class)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();

            return true;
        }else{
            return false;
        }
    }

    public static boolean save(CreateCustomerEvent createCustomerEvent){
        Boolean exists = localApiClient
                .post()
                .uri("/existsByUsername?username={username}", createCustomerEvent.getUsername())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if(Boolean.FALSE.equals(exists)){
            localApiClient
                    .post()
                    .uri("/updateCustomer")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(createCustomerEvent),Event.class)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();

            return true;
        }else{
            return false;
        }
    }

    public static boolean save(AddRoomEvent addRoomEvent){
        Boolean exists = localApiClient
                .post()
                .uri("/existsByRoomNumber?number={number}", addRoomEvent.getNumber())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if(Boolean.FALSE.equals(exists)){
            localApiClient
                    .post()
                    .uri("/updateRoom")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(addRoomEvent),Event.class)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();

            return true;
        }else{
            return false;
        }
    }

    public static boolean flush(){
        localApiClient
                .post()
                .uri("/flushDB")
                .retrieve()
                .bodyToMono(void.class)
                .block();

        return true;
    }
/*
    public Boolean query(Event event) {
        return localApiClient
                .post()
                .uri("/event")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }*/
}
