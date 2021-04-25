package com.example.dataTest.address;

import com.example.dataTest.customer.Customer;
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
    private Customer customer;


    protected Address() {}

    public Address(String street, String lastName, String city) {
        this.street = street;
        this.zip = lastName;
        this.city = city;
    }

}
