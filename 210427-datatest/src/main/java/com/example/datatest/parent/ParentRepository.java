package com.example.datatest.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;


public interface ParentRepository extends JpaRepository<ParentEntity, Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("SELECT pe FROM ParentEntity pe WHERE pe.id = :parentId")
    ParentEntity findByIdForceIncrement(@Param("parentId") Long parentEntityId);

}
