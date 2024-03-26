package at.fhv.buchungsPlattformRelDB.model;

import jakarta.persistence.*;

@Entity(name = "customer")
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday")
    private String birthday;

    public Customer(){

    }

    public Customer(String username, String name, String address, String birthday) {
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

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
