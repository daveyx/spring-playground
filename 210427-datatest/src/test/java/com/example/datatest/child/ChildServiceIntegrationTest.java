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
//        for debugging: (bp must not suspend all threads)
//        System.setProperty("java.awt.headless", "false");
//        DatabaseManagerSwing.main(new String[]{
//                "--url", "jdbc:hsqldb:mem:testdb", "--noexit"
//        });

        ParentEntity parentEntity = parentService.findAll().get(0);
        LocalDateTime before = parentEntity.getModificationTime();

        childService.save(new ChildEntity(parentEntity));

        LocalDateTime after = parentService.findById(parentEntity.getId()).getModificationTime();

        assertTrue(after.isAfter(before));
    }

}
