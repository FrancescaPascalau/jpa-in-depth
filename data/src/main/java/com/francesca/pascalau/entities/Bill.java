package com.francesca.pascalau.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
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

    @Version
    private Long version = 0L;
}
