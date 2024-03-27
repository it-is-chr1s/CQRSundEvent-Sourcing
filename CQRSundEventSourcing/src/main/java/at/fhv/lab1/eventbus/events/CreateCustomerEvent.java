package at.fhv.lab1.eventbus.events;

public class CreateCustomerEvent extends Event{
    private String username;
    private String name;
    private String address;
    private long birthday;
    private static int counter = 0;

    public CreateCustomerEvent(){
        super(counter++);
        eventType = EventType.CREATE_CUSTOMER_EVENT;
    }

    public CreateCustomerEvent(String username, String name, String address, long birthday) {
        this();
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "CreateCustomerEvent{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", timestamp=" + getTimestamp() +
                ", id=" + getEventID() +
                '}';
    }
}
