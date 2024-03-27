package at.fhv.lab1.eventbus.subscriber;

import at.fhv.lab1.eventbus.events.EventType;

public class Subscriber {
    private EventType type;
    private String client;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
