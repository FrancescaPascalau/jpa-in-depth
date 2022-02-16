package com.francesca.pascalau.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Bill {

    @Id
    @Column(name = "BILL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    private long amount;

    @ManyToOne
    private Contract contract;
}
