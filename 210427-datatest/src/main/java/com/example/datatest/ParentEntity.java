package com.example.datatest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
@Entity
public class ParentEntity extends AbstractEntity {

    private String data;

}
