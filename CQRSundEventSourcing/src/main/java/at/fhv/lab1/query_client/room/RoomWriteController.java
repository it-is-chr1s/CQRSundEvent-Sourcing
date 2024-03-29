package at.fhv.lab1.query_client.room;

import at.fhv.lab1.eventbus.events.EventType;
import at.fhv.lab1.query_client.WriteController;
import at.fhv.lab1.query_client.customer.Customer;
import at.fhv.lab1.query_client.customer.CustomerList;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class RoomWriteController extends WriteController {
    private final RoomList roomList = RoomList.initialize();

    @Override
    public void run(String... args) throws InterruptedException {
        subscribe(EventType.ADD_ROOM_EVENT, "http://localhost:8085", Thread.currentThread());
        subscribe(EventType.DELETE_ALL_EVENT, "http://localhost:8085", Thread.currentThread());
    }

    @PostMapping(value = "/ADD_ROOM_EVENT", consumes = "application/json")
    public void createCustomer(@RequestBody Room room){
        roomList.insert(room);
        System.out.println("Added room: " + room);
    }

    @PostMapping(value = "/DELETE_ALL_EVENT")
    public void deleteAll(){
        roomList.deleteAll();
        System.out.println("All rooms deleted.");
    }
}
