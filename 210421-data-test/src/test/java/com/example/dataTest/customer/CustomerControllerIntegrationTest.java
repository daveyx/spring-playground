package com.example.dataTest.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer customer;


    @BeforeEach
    public void beforeEach() {
        customer = customerRepository.save(new Customer("DareIT", "LLC"));
        customer = customerService.save(new Customer("DareIT", "LLC"));
    }

    @Test
    void testAddPerson() throws Exception {
        MvcResult mvcResult
                = mvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/customer/" + customer.getId())).andReturn();

        String json = mvcResult.getResponse().getContentAsString();

//        does not work, as java.lang.Object.equals is called
//        assertEquals(customer, objectMapper.readValue(json, Customer.class));

        assertEquals(objectMapper.writeValueAsString(customer), json);
    }

}
