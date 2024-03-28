package at.fhv.lab1.query_client.booking;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Component
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BookingReadController {

    private final BookingList bookingList = BookingList.initialize();

    @PostMapping(value = "/getBookings")
    public ArrayList<Booking> getBookings(@RequestParam long startDate, long endDate){
        ArrayList<Booking> bookings = bookingList.getBookings(startDate, endDate);
        System.out.println("Doing");
        for(Booking booking : bookings){
            System.out.println(booking);
        }
        return bookings;
    }
}
