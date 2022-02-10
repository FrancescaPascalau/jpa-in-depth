package com.francesca.pascalau.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bill implements Serializable {

    @Id
    @Column(name = "BILL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "CONTRACT_ID", referencedColumnName = "CONTRACT_ID")
    private Contract contract;
}
