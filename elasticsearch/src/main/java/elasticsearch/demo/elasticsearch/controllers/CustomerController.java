package elasticsearch.demo.elasticsearch.controllers;

import elasticsearch.demo.elasticsearch.model.Customer;
import elasticsearch.demo.elasticsearch.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/saveCustomer")
    public int saveCustomer(@RequestBody List<Customer> customers) {
        customerRepository.saveAll(customers);
        return customers.size();
    }

    @GetMapping("/findAll")
    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/findByFName/{firstName}")
    public List<Customer> findByFirstName(@PathVariable String firstName) {
        return customerRepository.findByFirstname(firstName);
    }
}
