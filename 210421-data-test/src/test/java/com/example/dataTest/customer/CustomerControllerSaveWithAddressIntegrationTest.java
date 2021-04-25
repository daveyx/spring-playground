package com.example.dataTest.customer;

import com.example.dataTest.address.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class CustomerControllerSaveWithAddressIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerService customerService;


    @BeforeAll
    public static void beforeAll() {
//        for debugging: (bp must not suspend all threads)
//        System.setProperty("java.awt.headless", "false");
//        DatabaseManagerSwing.main(new String[]{
//                "--url", "jdbc:hsqldb:mem:testdb", "--noexit"
//        });
    }

    @Test
    void neverTrustAFrontend() throws Exception {
        createTestData();

        Customer customer1 = getCustomer(1L);
        customer1.getAddresses().iterator().next().setId(2L);
        customer1.getAddresses().iterator().next().setStreet("modifying another address");

        mvc.perform(post("/customer")
                .content(objectMapper.writeValueAsString(customer1))
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        assertEquals(0, getCustomer(2L).getAddresses().size()); // wrong! -> should be 1
    }

    private Customer getCustomer(Long id) throws Exception {
        MvcResult mvcResult
                = mvc.perform(get("/customer/" + id)).andReturn();

        return objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Customer.class);
    }

    private void createTestData() {
        Customer customer1 = new Customer("firstname1", "lastname1");
        Address address1 = new Address("street1", "zip1", "city1");
        address1.setCustomer(customer1);
        customer1.setAddresses(Collections.singleton(address1));
        customerService.save(customer1);

        Customer customer2 = new Customer("firstname2", "lastname2");
        Address address2 = new Address("street2", "zip2", "city2");
        address2.setCustomer(customer2);
        customer2.setAddresses(Collections.singleton(address2));
        customerService.save(customer2);
    }

}
