package at.fhv.lab1.eventbus.events;

public class CreateCustomerEvent implements Event{
    private String name;
    private String address;
    private String birthday;
    private long timestamp;

    public CreateCustomerEvent(){
        this.timestamp = System.currentTimeMillis();
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CreateCustomerEvent{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
