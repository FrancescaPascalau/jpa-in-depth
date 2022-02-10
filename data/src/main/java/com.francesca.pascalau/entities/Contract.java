package com.francesca.pascalau.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Contract implements Serializable {

    @Id
    @Column(name = "CONTRACT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String details;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract")
    private List<Bill> bills;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contract")
    private Customer customer;
}
