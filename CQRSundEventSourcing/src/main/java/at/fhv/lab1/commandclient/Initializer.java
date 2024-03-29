package at.fhv.lab1.commandclient;

import at.fhv.lab1.eventbus.events.*;

import java.time.Duration;

public class Initializer {

    private static EventPublisher publisher = EventPublisher.initialize();

    public static void basicDataset(){
         Event[] events = {
                 new DeleteAllEvent(),
                 new AddRoomEvent(1, 2, true),
                 new AddRoomEvent(2, 2, true),
                 new AddRoomEvent(3, 2, false),
                 new AddRoomEvent(4, 2, false),
                 new AddRoomEvent(5, 4, true),
                 new AddRoomEvent(6, 4, true),
                 new AddRoomEvent(7, 4, true),
                 new AddRoomEvent(8, 4, true),
                 new AddRoomEvent(9, 4, true),
                 new AddRoomEvent(10, 4, false),
                 new CreateCustomerEvent("M&M", "Max Mustermann", "Musterstraße", System.currentTimeMillis()),
                 new BookRoomEvent(System.currentTimeMillis(), System.currentTimeMillis() + Duration.ofDays(2).toMillis(), 2, "M&M")
         };

         init(events);
    }

    private static void init(Event[] events){
        for(Event event : events){
            if(event instanceof AddRoomEvent) {
                if (RelationalDatabase.save((AddRoomEvent) event)) {
                    publisher.publishEvent(event);
                }
            }else if(event instanceof DeleteAllEvent){
                if (RelationalDatabase.flush()){
                    publisher.publishEvent(event);
                }
            }else if(event instanceof CreateCustomerEvent){
                if(RelationalDatabase.save((CreateCustomerEvent) event)){
                    publisher.publishEvent(event);
                }
            }else if(event instanceof BookRoomEvent){
                if(RelationalDatabase.save((BookRoomEvent) event)){
                    publisher.publishEvent(event);
                }
            }
        }
    }
}
