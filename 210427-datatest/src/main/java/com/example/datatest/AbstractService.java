package com.example.datatest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Transactional
public abstract class AbstractService<ENTITY extends AbstractEntity> {

    private final JpaRepository<ENTITY, Long> repository;


    public ENTITY findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ENTITY> findAll() {
        return repository.findAll();
    }

    public ENTITY save(ENTITY entity) {
        return repository.save(entity);
    }

}
