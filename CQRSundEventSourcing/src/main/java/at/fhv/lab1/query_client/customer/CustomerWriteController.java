package at.fhv.lab1.query_client.customer;

import at.fhv.lab1.eventbus.events.EventType;
import at.fhv.lab1.query_client.WriteController;
import at.fhv.lab1.query_client.booking.Booking;
import at.fhv.lab1.query_client.booking.BookingList;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class CustomerWriteController extends WriteController {
    private final CustomerList customerList = CustomerList.initialize();

    @Override
    public void run(String... args) throws InterruptedException {
        subscribe(EventType.CREATE_CUSTOMER_EVENT, "http://localhost:8084", Thread.currentThread());
    }

    @PostMapping(value = "/CREATE_CUSTOMER_EVENT", consumes = "application/json")
    public void createCustomer(@RequestBody Customer customer){
        customerList.insert(customer);
        System.out.println("Booking received: " + customer);
    }
}