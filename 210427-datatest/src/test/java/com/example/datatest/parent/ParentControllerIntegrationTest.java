package com.example.datatest.parent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class ParentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ParentRepository parentRepository;


    @BeforeEach
    void beforeEach() {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setData("data in hsqldb");
        parentRepository.save(parentEntity);
    }

    @Disabled
    @Test
    void test_equals() throws Exception {
        String actual = mockMvc.perform(get("/parent/1")).andReturn().getResponse().getContentAsString();

        assertEquals(actual, createExpected());
    }

    private String createExpected() throws JsonProcessingException {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setData("data in hsqldb");
        ReflectionTestUtils.setField(parentEntity, "id", 1L);
        return objectMapper.writeValueAsString(parentEntity);
    }

    @Test
    void test_get() throws Exception {
        String actual = mockMvc.perform(get("/parent")).andReturn().getResponse().getContentAsString();
        System.out.println();
    }

    @Test
    void test_get_withParam() throws Exception {
        String actual = mockMvc.perform(get("/parent?param=param")).andReturn().getResponse().getContentAsString();
        System.out.println();
    }

}
