package com.example.datatest.child;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ChildRepository extends JpaRepository<ChildEntity, Long> {
}
