package com.francesca.pascalau.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractRequest {

    private Long customerId;
    private Long amount;
    private int pageNumber;
    private int pageSize;
}
