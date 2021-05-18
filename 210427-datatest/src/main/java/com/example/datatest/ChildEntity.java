package com.example.datatest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;


@Getter
@Setter
public class ChildEntity extends AbstractEntity {

    private String data;

    @ManyToOne
    private ParentEntity parentEntity;


    public ChildEntity(ParentEntity parentEntity) {
        this.parentEntity = parentEntity;
    }

}
