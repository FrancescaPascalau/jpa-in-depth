package com.francesca.pascalau.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Contract {

    @Id
    @Column(name = "CONTRACT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String details;

    @OneToMany(mappedBy = "contract")
    private List<Bill> bills;

    @OneToOne
    private Customer customer;
}
