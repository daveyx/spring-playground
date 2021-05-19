package com.example.datatest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@RequiredArgsConstructor
public abstract class AbstractService<ENTITY extends AbstractEntity> {

    private final JpaRepository<ENTITY, Long> repository;


    public List<ENTITY> findAll() {
        return repository.findAll();
    }

    public ENTITY save(ENTITY entity) {
        return repository.save(entity);
    }

}
