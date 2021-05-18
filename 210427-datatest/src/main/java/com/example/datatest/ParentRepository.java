package com.example.datatest;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
}
