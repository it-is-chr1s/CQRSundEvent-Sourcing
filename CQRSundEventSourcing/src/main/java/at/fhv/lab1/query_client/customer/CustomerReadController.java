package at.fhv.lab1.query_client.customer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Component
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerReadController {

    private final CustomerList customerList = CustomerList.initialize();

    @PostMapping(value = "/getCustomers")
    public ArrayList<Customer> getCustomers(@RequestParam(required = false) String name){
        ArrayList<Customer> customers = (name.isEmpty()) ? customerList.getCustomers() : customerList.getCustomers(name);
        System.out.println("Doing");
        for(Customer customer : customers){
            System.out.println(customer);
        }
        return customers;
    }
}