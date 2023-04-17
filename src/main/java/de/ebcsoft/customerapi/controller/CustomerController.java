package de.ebcsoft.customerapi.controller;

import de.ebcsoft.customerapi.dto.CustomerDto;
import de.ebcsoft.customerapi.entity.CustomerEntity;
import de.ebcsoft.customerapi.repository.CustomerRepository;
import de.ebcsoft.customerapi.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("")
    @Operation(description = "shows all customers from DB in JSON format", method = "index", summary = "gets all customers")
    public List<CustomerDto> index() {
        return customerService.getAll();
    }

    @GetMapping("/one/{id}")
    @Operation(description = "shows that one customer with the specific id", method = "getCustomer", summary = "gets one customer")
    public CustomerDto getCustomer(@PathVariable("id") @Parameter(name = "id", description = "Customer ID", example = "1") Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    @Operation(description = "creates a new customer in DB from JSON", summary = "creates new customer", method = "createCustomer")
    public String createCustomer(@RequestBody @Parameter(example = "{\"firstName\": \"name1\", \"lastName\": \"name2\", \"city\": \"city\", \"birthdayDay\": \"1990-01-01\", \"secret\": \"secret\"") CustomerEntity customerEntity) {
        return customerService.createCustomer(customerEntity);
    }

    @PutMapping
    @Operation(description = "updates a specific customer", method = "updateCustomer", summary = "updates a customer")
    public String updateCustomer(@RequestBody @Parameter(example = "{\"id\": 1, \"firstName\": \"name1\", \"lastName\": \"name2\", \"city\": \"city\", \"birthdayDay\": \"1990-01-01\", \"secret\": \"secret\"") CustomerEntity customerEntity) {
        return customerService.updateCustomer(customerEntity);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(description = "deletes a specific customer", summary = "deletes a customer", method = "deleteCustomer")
    public String deleteCustomer(@PathVariable /*@Parameter(name = "Customer ID", example = "1", required = true) */Long id) {
        return customerService.deleteCustomer(id);
    }

}
