package com.example.datatest;

import lombok.Getter;

import javax.persistence.ManyToOne;


@Getter
public class RelatedEntity extends AbstractEntity {

    @ManyToOne
    private Entity entity;


    public RelatedEntity(Entity entity) {
        this.entity = entity;
    }

}
