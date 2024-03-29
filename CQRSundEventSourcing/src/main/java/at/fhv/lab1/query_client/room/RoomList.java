package at.fhv.lab1.query_client.room;

import at.fhv.lab1.query_client.booking.Booking;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoomList {
    private static class Entry extends Room {
        Entry next;

        public Entry(Room room) {
            super(room.getNumber(), room.getNumberOfBeds(), room.isBath());
        }
    }

    private static RoomList instance;

    private final WebClient localApiClient = WebClient.create("http://localhost:8083");

    private Entry head;

    private RoomList() {

    }

    public static RoomList initialize() {
        if (instance == null) {
            instance = new RoomList();
        }

        return instance;
    }

    public void insert(Room room) {
        Entry entry = new Entry(room);

        if (head == null || entry.getNumberOfBeds() < head.getNumberOfBeds()) {
            entry.next = null;
            head = entry;
        } else {
            Entry current = head;
            Entry prev = null;

            while (current != null && current.getNumberOfBeds() <= entry.getNumberOfBeds()) {
                prev = current;
                current = current.next;
            }

            entry.next = current;
            if(prev != null)
                prev.next = entry;
        }
    }

    public ArrayList<Room> getFreeRooms(long startDate, long endDate, int beds){
        ArrayList<Room> freeRooms = new ArrayList<>();
        ArrayList<Booking> bookings;

        bookings = localApiClient
                .post()
                .uri("/getBookings?startDate={startDate}&endDate={endDate}", startDate, endDate)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ArrayList<Booking>>(){})
                .block();

        Entry current = head;

        while(current != null){
            if(current.getNumberOfBeds() >= beds && !contains(current, bookings, startDate, endDate)){
                freeRooms.add(current);
            }
            current = current.next;
        }

        return freeRooms;
    }

    private boolean contains(Entry current, ArrayList<Booking> bookings, long startDate, long endDate){
        for(Booking booking : bookings){
            if(booking.getRoomNumber() == current.getNumber()
                    && ((booking.getEndDate() >= startDate && booking.getEndDate() <= endDate)
                    || (booking.getStartDate() >= startDate && booking.getStartDate() <= endDate))){
                return true;
            }
        }

        return false;
    }
}
