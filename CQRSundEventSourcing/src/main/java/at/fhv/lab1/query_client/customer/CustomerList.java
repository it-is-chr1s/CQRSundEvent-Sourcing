package at.fhv.lab1.query_client.customer;

import java.util.ArrayList;

public class CustomerList {
    private static class Entry extends Customer {
        Entry next;

        public Entry(Customer customer){
            super(customer.getUsername(), customer.getName(), customer.getAddress(), customer.getBirthday());
        }
    }

    private static CustomerList instance;

    private Entry head;

    private CustomerList(){

    }

    public static CustomerList initialize(){
        if(instance == null){
            instance = new CustomerList();
        }

        return instance;
    }

    public void insert(Customer customer) {
        Entry entry = new Entry(customer);

        if (head == null || entry.getUsername().compareTo(head.getUsername()) < 0) {
            entry.next = null;
            head = entry;
        } else {
            Entry current = head;
            Entry prev = null;

            while (current != null && entry.getUsername().compareTo(current.getUsername()) > 0) {
                prev = current;
                current = current.next;
            }

            entry.next = current;
            if(prev != null)
                prev.next = entry;
        }
    }

    public ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();

        Entry current = head;

        while(current != null){
            customers.add(current);
            current = current.next;
        }

        return customers;
    }

    public ArrayList<Customer> getCustomers(String name){
        ArrayList<Customer> customers = new ArrayList<>();

        Entry current = head;

        while(current != null){
            if(current.getName().equals(name)){
                customers.add(current);
            }
            current = current.next;
        }

        return customers;
    }
}
