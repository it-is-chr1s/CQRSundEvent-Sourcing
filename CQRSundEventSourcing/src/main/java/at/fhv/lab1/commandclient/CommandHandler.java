package at.fhv.lab1.commandclient;

import at.fhv.lab1.eventbus.events.BookRoomEvent;
import at.fhv.lab1.eventbus.events.CancelBookingEvent;
import at.fhv.lab1.eventbus.events.CreateCustomerEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class CommandHandler {

    private final EventPublisher publisher;

    public CommandHandler(RelationalDatabase db){
        this.publisher = EventPublisher.initialize();
    }

    @PostMapping(value = "/createCustomer", consumes = "application/json")
    public ResponseEntity<String> createCustomer(@RequestBody CreateCustomerEvent createCustomerEvent){
        System.out.println("Received Post request: " + createCustomerEvent);

        if(RelationalDatabase.save(createCustomerEvent)){
            publisher.publishEvent(createCustomerEvent);
            return ResponseEntity.ok("Customer has been created.");
        }else{
            return ResponseEntity.unprocessableEntity().body("Customer hasn't been created.");
        }
    }

    @PostMapping(value = "/bookRoom", consumes = "application/json")
    public ResponseEntity<String> bookRoom(@RequestBody BookRoomEvent bookRoomEvent){
        System.out.println("Received Post request: " + bookRoomEvent);

        if(RelationalDatabase.save(bookRoomEvent)){
            publisher.publishEvent(bookRoomEvent);
            return ResponseEntity.ok("The room has been booked.");
        }else{
            return ResponseEntity.unprocessableEntity().body("The room hasn't been booked.");
        }
    }

    @PostMapping(value = "/cancelBooking", consumes = "application/json")
    public ResponseEntity<String> cancelBooking(@RequestBody CancelBookingEvent cancelBookingEvent){
        System.out.println("Received Post request: " + cancelBookingEvent);

        if(RelationalDatabase.deleteBooking(cancelBookingEvent.getReservationNumber())){
            publisher.publishEvent(cancelBookingEvent);

            return ResponseEntity.ok("The reservation number has been canceled.");
        }else{
            return ResponseEntity.unprocessableEntity().body("The reservation number hasn't been canceled.");
        }
    }

    @PostMapping(value = "/initializeDatabase")
    public String initialiseDatabase(){
        Initializer.basicDataset();

        return "The Database has been initialised with the basic Dataset";
    }
}
