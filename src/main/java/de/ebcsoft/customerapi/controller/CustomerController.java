package de.ebcsoft.customerapi.controller;

import de.ebcsoft.customerapi.entity.Customer;
import de.ebcsoft.customerapi.repository.CustomerRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepositoy customerRepositoy;

    public CustomerController(CustomerRepositoy customerRepositoy) {
        this.customerRepositoy = customerRepositoy;
    }

    @GetMapping("")
    public List<Customer> index() {
        return customerRepositoy.findAll();
    }

    @PostMapping("")
    public void createCustomer(@RequestBody Customer customer){
        customerRepositoy.save(customer);
    }

    @DeleteMapping("")
    public void deleteCustomer(@PathVariable Long customerId) {
        Optional<Customer> customer = customerRepositoy.findById(customerId);
        if(customer.isPresent()) {
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with this id not found");
    }

}
