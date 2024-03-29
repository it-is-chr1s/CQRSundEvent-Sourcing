package at.fhv.buchungsPlattformRelDB;

import at.fhv.buchungsPlattformRelDB.model.Booking;
import at.fhv.buchungsPlattformRelDB.model.Customer;
import at.fhv.buchungsPlattformRelDB.model.Room;
import at.fhv.buchungsPlattformRelDB.repository.BookingRepository;
import at.fhv.buchungsPlattformRelDB.repository.CustomerRepository;
import at.fhv.buchungsPlattformRelDB.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class RelDBApplication {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public static void main(String[] args) {
        SpringApplication.run(RelDBApplication.class, args);
    }

    /*{
        "username": "YOUR_USERNAME",
            "name": "YOUR_NAME",
            "address": "YOUR_ADDRESS",
            "birthday": "YOUR_BIRTHDAY DD-MM-YYYY"
    }*/
    @PostMapping("/updateCustomer")
    public Customer updateCustommer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PostMapping("/existsByUsername")
    public boolean existsByUsername(@RequestParam String username){
        return customerRepository.existsByUsername(username);
    }

    /*
    {"number": 2, "numberOfBeds": 2, "bath": true}
     */
    @PostMapping("/updateRoom")
    public Room updateRooms(@RequestBody Room room){
        return roomRepository.save(room);
    }

    @PostMapping("/existsByRoomNumber")
    public boolean existsByRoomNumber(@RequestParam int number){
        return roomRepository.existsByNumber(number);
    }

    /*
    {
        "reservationNumber": 12345,
            "startDate": "2024-03-27",
            "endDate": "2024-03-30"
    }*/
    @PostMapping("/updateBooking")
    public Booking bookRoom(@RequestParam int roomNumber, @RequestParam String username,  @RequestBody Booking booking){
        booking.setRoom(roomRepository.findByNumber(roomNumber));
        booking.setCustomer(customerRepository.findByUsername(username));
        System.out.println(booking);
        return bookingRepository.save(booking);
    }

    @PostMapping("/existsByReservationNumber")
    public boolean existsByReservationNumber(@RequestParam int reservationNumber){
        return bookingRepository.existsByReservationNumber(reservationNumber);
    }

    @PostMapping("/deleteBooking")
    @Transactional
    public ResponseEntity<?> deleteBooking(@RequestParam int reservationNumber) {
        Booking booking = bookingRepository.findByReservationNumber(reservationNumber);

        if (booking == null) {
            return ResponseEntity.notFound().build();
        }

        bookingRepository.deleteByReservationNumber(booking.getReservationNumber());

        return ResponseEntity.ok("Booking with reservation number " + reservationNumber + " deleted successfully.");
    }

    @PostMapping("/flushDB")
    public void flushDB() throws InterruptedException {
        bookingRepository.deleteAll();
        while(bookingRepository.count() > 0) {
            bookingRepository.deleteAll();
            System.out.println("Waiting for bookings to be deleted");
            Thread.sleep(100);
        }
        customerRepository.deleteAll();
        roomRepository.deleteAll();
    }
}