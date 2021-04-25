package com.example.dataTest.customer;

import com.example.dataTest.address.Address;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;


@SpringBootTest
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerService customerService;


    @Test
    void test() {
        Customer customer = createCustomer();
        Address address = new Address("street1", "zip1", "city1");
        address.setCustomer(customer);
        customer.setAddresses(Collections.singleton(address));

        customerService.save(customer);

        // access to getAddresses() works with controller because "spring.jpa.open-in-view" is true by default
        Assertions.assertThrows(LazyInitializationException.class, () -> customerService.getById(1L).getAddresses().size());
    }

    private Customer createCustomer() {
        return new Customer("DareIT", "LLC");
    }

}
