package com.example.datatest.child;

import com.example.datatest.parent.ParentEntity;
import com.example.datatest.parent.ParentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ChildServiceIntegrationTest {

    @Autowired
    private ChildService childService;

    @Autowired
    private ParentService parentService;


    @Test
    void test_save_modifiedParentEntityModificationTime() {
        ParentEntity parentEntity = parentService.findAll().get(0);
        LocalDateTime before = parentEntity.getModificationTime();

        ChildEntity childEntity = new ChildEntity(parentEntity);

        childEntity = childService.save(childEntity);
        LocalDateTime after = childEntity.getParentEntity().getModificationTime();

        assertTrue(after.isAfter(before));
    }

}
