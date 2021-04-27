package com.example.datatest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Repository repository;


    @BeforeEach
    void beforeEach() {
        Entity entity = new Entity();
        entity.setData("data in hsqldb");
        repository.save(entity);
    }

    @Test
    void test() throws Exception {
        String actual
                = mockMvc.perform(get("/controller/1")).andReturn().getResponse().getContentAsString();

        assertEquals(actual, createExpected());
    }

    private String createExpected() throws JsonProcessingException {
        Entity entity = new Entity();
        entity.setData("data in hsqldb");
        entity.setId(1L);
        return objectMapper.writeValueAsString(entity);
    }

}
