package com.example.datatest.parent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ParentServiceIntegrationTest {

    @Autowired
    public ParentService parentService;


    @Test
    void test_findAll() {
        List<ParentEntity> parentEntities = parentService.findAll();
        assertNotNull(parentEntities);
    }

    @Test
    void test_save() {
        List<ParentEntity> parentEntities = parentService.findAll();
        LocalDateTime modificationTimeBeforeSave = parentEntities.get(0).getModificationTime();

        parentEntities.get(0).setData("asdf");

        LocalDateTime modificationTimeAfterSave = parentService.save(parentEntities.get(0)).getModificationTime();

        assertTrue(modificationTimeAfterSave.isAfter(modificationTimeBeforeSave));
    }

}
