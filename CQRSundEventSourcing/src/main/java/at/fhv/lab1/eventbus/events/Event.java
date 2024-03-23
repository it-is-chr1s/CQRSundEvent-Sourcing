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
        @JsonSubTypes.Type(value = BookRoomEvent.class, name = "BookRoomEvent"),
        @JsonSubTypes.Type(value = CancelBookingEvent.class, name = "CancelBookingEvent"),
        @JsonSubTypes.Type(value = CreateCustomerEvent.class, name = "CreateCustomerEvent")
})
public abstract class Event {
    private String eventType;

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType(){
        return eventType;
    }

    public abstract long getTimestamp();
    public abstract void setTimestamp(long timestamp);
}

