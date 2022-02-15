package com.francesca.pascalau.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContractRequest {

    private Long customerId;
    private Long amount;
    private int pageNumber;
    private int pageSize;
}
