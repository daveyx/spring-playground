package com.example.dataTest.address;

import com.example.dataTest.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zip;
    private String city;

    @ManyToOne
    @JsonIgnore
    private Customer customer;


    protected Address() {}

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

}
