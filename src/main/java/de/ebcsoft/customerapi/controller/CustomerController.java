package de.ebcsoft.customerapi.controller;

import de.ebcsoft.customerapi.entity.Customer;
import de.ebcsoft.customerapi.repository.CustomerRepositoy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepositoy customerRepositoy;

    public CustomerController(CustomerRepositoy customerRepositoy) {
        this.customerRepositoy = customerRepositoy;
    }

    @GetMapping("")
    public List<Customer> index() {
        return customerRepositoy.findAll();
    }

}
