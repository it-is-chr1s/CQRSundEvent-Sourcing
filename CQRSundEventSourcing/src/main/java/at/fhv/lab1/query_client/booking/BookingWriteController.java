package at.fhv.lab1.query_client.booking;

import at.fhv.lab1.eventbus.events.EventType;
import at.fhv.lab1.query_client.WriteController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class BookingWriteController extends WriteController {
    private final BookingList bookingList = BookingList.initialize();

    @Override
    public void run(String... args) throws InterruptedException {
        subscribe(EventType.BOOK_ROOM_EVENT, "http://localhost:8083", Thread.currentThread());
        subscribe(EventType.CANCEL_BOOKING_EVENT, "http://localhost:8083", Thread.currentThread());
    }

    @PostMapping(value = "/BOOK_ROOM_EVENT", consumes = "application/json")
    public void bookRoom(@RequestBody Booking booking){
        bookingList.insert(booking);
        System.out.println("Booking received: " + booking);
    }

    @PostMapping(value = "/CANCEL_BOOKING_EVENT", consumes = "application/json")
    public void cancelBooking(@RequestBody Booking booking){
        bookingList.delete(booking.getReservationNumber());
        System.out.println("Booking cancelled: " + booking);
    }


}
