package com.example.datatest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.io.Serializable;


@NoRepositoryBean
public interface IRepository<ENTITY extends AbstractEntity, ID extends Serializable> extends JpaRepository<ENTITY, ID> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("SELECT entity FROM #{#entityName} entity WHERE entity.id = :entityId")
    ENTITY findByIdForceIncrement(@Param("entityId") Long entityId);

}
