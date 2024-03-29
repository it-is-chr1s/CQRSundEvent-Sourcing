package at.fhv.lab1.query_client.room;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Component
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class RoomReadController {

    private final RoomList roomList = RoomList.initialize();

    @PostMapping(value = "/getFreeRooms")
    public ArrayList<Room> getFreeRooms(@RequestParam long startDate, long endDate, int persons){
        ArrayList<Room> rooms = roomList.getFreeRooms(startDate, endDate, persons);
        System.out.println("Doing");
        for(Room room : rooms){
            System.out.println(room);
        }
        return rooms;
    }
}
