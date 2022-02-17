package com.francesca.pascalau.services;

import com.francesca.pascalau.model.BillDto;
import com.francesca.pascalau.model.ContractDto;
import com.francesca.pascalau.model.CustomerDto;
import com.francesca.pascalau.port.ContractServicePort;
import com.francesca.pascalau.request.ContractRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<ContractDto> findAllContracts(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return contractService.findAllContractsWithBills(pageable);
    }

    public Page<ContractDto> find(ContractRequest request) {
        Pageable pageable = PageRequest.of(request.getPageNumber(), request.getPageSize());

        return contractService.findAll(request, pageable);
    }

    public List<ContractDto> findByCustomerId(Long customerId) {
        return contractService.findAllByCustomerId(customerId);
    }

    public ContractDto findByContractId(Long contractId) {
        return contractService.findById(contractId);
    }

    public ContractDto findByContractIdWithLogs(Long contractId) {
        return contractService.findByIdWithLogs(contractId);
    }
}
