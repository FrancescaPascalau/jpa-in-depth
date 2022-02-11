package com.francesca.pascalau.services;

import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.BillDto.Type;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.port.BillServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillServicePort billService;

    public void addBill(ContractDto contract, Type type, long amount) {
        billService.create(BillDto.builder()
                .amount(amount)
                .type(type)
                .contract(contract)
                .build());
    }
}
