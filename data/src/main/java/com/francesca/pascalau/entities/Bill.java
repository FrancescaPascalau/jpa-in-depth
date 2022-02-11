package com.francesca.pascalau.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Bill {

    @Id
    @Column(name = "BILL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    private long amount;

    @ManyToOne
    private Contract contract;
}
