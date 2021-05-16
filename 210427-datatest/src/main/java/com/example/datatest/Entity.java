package com.example.datatest;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@javax.persistence.Entity
public class Entity extends AbstractEntity {

    private String data;

}
