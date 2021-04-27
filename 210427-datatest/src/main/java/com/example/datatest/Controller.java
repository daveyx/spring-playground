package com.example.datatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("controller")
public class Controller {

    @Autowired
    private Repository repository;


    @GetMapping("{id}")
    public ResponseEntity<Entity> get(@PathVariable Long id) {
        Optional<Entity> entity = repository.findById(id);

        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }

        return ResponseEntity.notFound().build();
    }

}
