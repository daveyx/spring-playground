package com.example.dataTest.customer;

import com.example.dataTest.address.Address;
import com.example.dataTest.address.AddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @BeforeAll
    public static void beforeAll() {
//        for debugging: (bp must not suspend all threads)
//        System.setProperty("java.awt.headless", "false");
//        DatabaseManagerSwing.main(new String[]{
//                "--url", "jdbc:hsqldb:mem:testdb", "--noexit"
//        });
    }

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    @Order(1)
    void testSaveCustomer() throws Exception {
        Customer customer = createCustomer();
        MvcResult mvcResult = mockMvc.perform(post("/customer")
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
        Customer customer = customerRepository.findById(1L).orElse(null);

        Address address = addressRepository.save(createAddress(customer));
        customer = createCustomer();
        ReflectionTestUtils.setField(customer, "id", 1L);
        ReflectionTestUtils.setField(customer, "addresses", Collections.singleton(address));

        MvcResult mvcResult = mockMvc.perform(get("/customer/1")).andReturn();

        String json = mvcResult.getResponse().getContentAsString();

//        does not work, as java.lang.Object.equals is called
//        assertEquals(customer, objectMapper.readValue(json, Customer.class));

        assertEquals(objectMapper.writeValueAsString(customer), json);
    }

    private Customer createCustomer() {
        Customer customer = new Customer("DareIT", "LLC");
        return customer;
    }

    private Address createAddress(Customer customer) {
        Address address = new Address("street", "zip", "city");
        address.setCustomer(customer);

        return address;
    }

}
