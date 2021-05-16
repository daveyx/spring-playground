package com.example.dataTest.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

}
