package com.example.dataTest.customer;

import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

}
