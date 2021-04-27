package com.example.datatest;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<Entity, Long> {
}
