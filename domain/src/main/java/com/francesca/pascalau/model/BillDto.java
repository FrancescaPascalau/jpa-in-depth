package com.francesca.pascalau.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    private Long id;
    private Type type;
    private Long amount;
    private Long version;
    private ContractDto contract;

    public enum Type {
        ELECTRICITY,
        GAS,
        WATER
    }
}
