package com.francesca.pascalau.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;
}
