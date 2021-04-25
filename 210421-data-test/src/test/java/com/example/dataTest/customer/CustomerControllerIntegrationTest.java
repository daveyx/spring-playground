package com.example.dataTest.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void beforeEach() {
    }

    @Test
    @Order(1)
    void testSaveCustomer() throws Exception {
        Customer customer = createCustomer();
        MvcResult mvcResult = mvc.perform(post("/customer")
                .content(objectMapper.writeValueAsString(customer))
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();

        customer.setId(1L);

        assertEquals(objectMapper.writeValueAsString(customer), json);
    }

    @Test
    @Order(2)
    void testGetCustomerById() throws Exception {
        MvcResult mvcResult
                = mvc.perform(get("/customer/1")).andReturn();

        String json = mvcResult.getResponse().getContentAsString();

//        does not work, as java.lang.Object.equals is called
//        assertEquals(customer, objectMapper.readValue(json, Customer.class));

        Customer customer = createCustomer();
        customer.setId(1L);

        assertEquals(objectMapper.writeValueAsString(customer), json);
    }

    private Customer createCustomer() {
        return new Customer("DareIT", "LLC");
    }

}
