package com.francesca.pascalau.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACT_ID")
    private Contract contract;
}
