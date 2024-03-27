package at.fhv.lab1.eventbus.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "eventType",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BookRoomEvent.class, name = "BOOK_ROOM_EVENT"),
        @JsonSubTypes.Type(value = CancelBookingEvent.class, name = "CANCEL_BOOKING_EVENT"),
        @JsonSubTypes.Type(value = CreateCustomerEvent.class, name = "CREATE_CUSTOMER_EVENT"),
        @JsonSubTypes.Type(value = DeleteAll.class, name = "DELETE_ALL_EVENT"),
        @JsonSubTypes.Type(value = AddRoomEvent.class, name = "ADD_ROOM_EVENT")
})
public abstract class Event {
    protected EventType eventType;
    private long timestamp;
    private int eventID;

    public Event(int id){
        timestamp = System.currentTimeMillis();
        eventID = id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventID(int id){
        this.eventID = id;
    }

    public int getEventID(){
        return eventID;
    }

    public long getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }
}

