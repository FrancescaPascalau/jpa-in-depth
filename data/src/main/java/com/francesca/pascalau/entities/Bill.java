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

    /**
     * Concept: FetchType.LAZY vs. FetchType.EAGER
     * Description:
     *      Eager Loading - data initialization occurs on the spot, data associated and will store it in a memory.
     *      Lazy Loading - defer initialization of an object as long as it's possible, data won't be initialized and loaded into a memory until we make an explicit call to it.
     * Solution: fetch = FetchType.LAZY or fetch = FetchType.EAGER
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @Version
    private Long version = 0L;
}
