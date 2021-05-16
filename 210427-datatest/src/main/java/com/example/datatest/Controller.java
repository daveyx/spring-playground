package com.example.datatest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("controller")
public class Controller {

    private final Repository repository;


    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Entity> get(@RequestParam(value = "param", required = false) String param) {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<Entity> get(@PathVariable Long id) {
        Optional<Entity> entity = repository.findById(id);

        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }

        return ResponseEntity.notFound().build();
    }

}
