package com.francesca.pascalau.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {

    private Long id;
    private String details;
    private List<BillDto> bills;
    private CustomerDto customer;
}