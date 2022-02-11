package com.francesca.pascalau.services;

import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.model.CustomerDto;
import com.francesca.pascalau.port.ContractServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractServicePort contractService;

    public ContractDto createContract(CustomerDto customerDto) {
        var contract = ContractDto.builder()
                .id(1L)
                .details("Test contract")
                .customer(customerDto)
                .build();

        contractService.create(contract);

        return contract;
    }

    public List<BillDto> findAllBills(Long contractId) {
       return contractService.findAllBills(contractId);
    }
}
