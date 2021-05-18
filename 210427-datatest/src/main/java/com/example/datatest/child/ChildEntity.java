package com.example.datatest.child;

import com.example.datatest.AbstractEntity;
import com.example.datatest.parent.ParentEntity;
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
