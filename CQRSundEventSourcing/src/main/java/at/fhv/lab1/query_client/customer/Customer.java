package at.fhv.lab1.query_client.customer;

public class Customer {
    private String username;
    private String name;
    private String address;
    private long birthday;

    public Customer(String username, String name, String address, long birthday) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
