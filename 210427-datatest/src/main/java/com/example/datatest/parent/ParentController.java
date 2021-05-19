package com.example.datatest.parent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("parent")
public class ParentController {

    private final ParentRepository parentRepository;


    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @GetMapping
    public ResponseEntity<ParentEntity> get(@RequestParam(value = "param", required = false) String param) {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<ParentEntity> get(@PathVariable Long id) {
        Optional<ParentEntity> entity = parentRepository.findById(id);

        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }

        return ResponseEntity.notFound().build();
    }

}
