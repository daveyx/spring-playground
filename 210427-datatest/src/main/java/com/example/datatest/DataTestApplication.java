package com.example.datatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class DataTestApplication {

    @Autowired
    private Repository repository;


    public static void main(String[] args) {
        SpringApplication.run(DataTestApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
//        for debugging: (bp must not suspend all threads)
//        System.setProperty("java.awt.headless", "false");
//        DatabaseManagerSwing.main(new String[]{
//                "--url", "jdbc:hsqldb:mem:testdb", "--noexit"
//        });
        Entity entity = new Entity();
        entity.setData("data in hsqldb");
        repository.save(entity);
    }

}
